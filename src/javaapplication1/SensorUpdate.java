/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jyots
 */
public class SensorUpdate extends TimerTask {
    
    public void run(){
        try {
            //Email id and password
            
            String email_from = "shubhiag1234@gmail.com";
            String password = "AnotherPassword";
            //System.out.println("Timer task executed.");
            
            //Loop through the database and update the values in the local hashMap landing.dustbin
            
            //For now, updating the sensor values in the hashmap with random values
            
            //Setting the initial driver id to 0. Driver number will be incremented whenever the mail is sent.
            
            int vanID = 0;
            Mailer obj = new Mailer();
            Timestamp ts;
            String log;
            
            final String DB_URL = "jdbc:derby:database;create=true";
            Connection conn = DriverManager.getConnection(DB_URL);
            String qu_dustbin ="SELECT * FROM DUSTBIN";
            PreparedStatement statement = conn.prepareStatement(qu_dustbin);
            ResultSet rs_dustbin = statement.executeQuery();
//            ResultSet rs_dustbin = landing.databaseHandler.execQuery(qu_dustbin);
            try {
                while(rs_dustbin.next()){
                    //System.out.println(entry.getKey() + " = " + entry.getValue());
                    int errorFlag = 0, logFlag = 0;
                    Random rand = new Random();
                    String currentID = rs_dustbin.getString("ID");
                    String qu_update = "UPDATE DUSTBIN SET sensedMoisture = "+rand.nextDouble()*100+", sensedGarbageDepth = "+rand.nextDouble()*100 +"WHERE ID = '" + currentID + "'";
                    if(landing.databaseHandler.execAction(qu_update)){
                        System.out.println("Sensed moisture and sensed garbage depth updated");
                    }else{
                        //error message
                    }
                    //System.out.println(entry.getKey() + " values updated.\tMoisture: " + entry.getValue().sensedMoisture + "\tGarbage Depth: " + entry.getValue().sensedGarbageDepth);
                    
                    if(rs_dustbin.getDouble("sensedGarbageDepth") >= landing.ultrasonicThreshold){
                        //System.out.println(entry.getValue().ID + " is full!");
                        int delay = rs_dustbin.getInt("delay");
                        qu_update = "UPDATE DUSTBIN SET isFull = true, delay = delay + 1 WHERE ID = '" + currentID + "'";
                        if(landing.databaseHandler.execAction(qu_update)){
                            // Add log
                            logFlag = 1;
                        }else{
                            // error
                        }
                        
                        //Mailing
                        if(!rs_dustbin.getBoolean("isMailSentToVan")){
                            if(logFlag==1){
                                ts = new Timestamp(System.currentTimeMillis());
                                log = ts + " : Dustbin: " + currentID + " detected full.\n";
                                landing.logReport += log;
                            }
                            String van_key = Integer.toString(landing.vanIDIndex);
                            
                            //                        if(!landing.van.containsKey(van_key))
                            //                        vanID = 0;
                            //                        van_key = Integer.toString(vanID);
                            
                            landing.vanIDIndex++;
                            String qu_c = "SELECT COUNT(*) FROM VAN";
                            ResultSet rs_c = landing.databaseHandler.execQuery(qu_c);
                            int count = 0;
                            try {
                                rs_c.next();
                                count = rs_c.getInt(1);
                            } catch (SQLException ex) {
                                Logger.getLogger(SensorUpdate.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(landing.vanIDIndex >= count)
                                landing.vanIDIndex = 0;
                            //System.out.println(landing.van.get("0").email);
                            String qu = "SELECT * FROM VAN WHERE id = '" + van_key + "'";
                            ResultSet rs = landing.databaseHandler.execQuery(qu);
                            String email_to="";
                            try{
                                if(rs.next())
                                    email_to = rs.getString("email");
                            } catch (SQLException ex) {
                                Logger.getLogger(SensorUpdate.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String sub = "Dustbin number : " + currentID + " is full" ;
                            String text = "Dustbin number : " + currentID + " placed at: " + rs_dustbin.getString("location") + " has reached the threshold of " + landing.ultrasonicThreshold + "cm. Clean it as soon as possible.";
                            try{
                                obj.send(email_from, password, email_to, sub, text);
                            }catch(Exception e){
                                errorFlag = 1;
                                System.out.println("Error in mailing to van. Catch executed.");
                            }
                            if(errorFlag==0){
                                qu_update = "UPDATE DUSTBIN SET isMailSentToVan = true WHERE ID = '" + currentID +"'";
                                if(landing.databaseHandler.execAction(qu_update)){
                                    //Add Log
                                    ts = new Timestamp(System.currentTimeMillis());
                                    log = ts + " : Mail sent to van: " + van_key + " To empty the dustbin: " + currentID + "\n";
                                    landing.logReport += log;
                                }
                            }
                            //entry.getValue().mailSentToVanId = van_key
                        }
                        
                        if(!rs_dustbin.getBoolean("isMailSentToAuthority") && rs_dustbin.getInt("delay")*5 >= landing.vanResponseDelay){
                            //Send mail to authority
                            String email_to = "iit2019171@iiita.ac.in";
                            String sub = "Delay in cleaning of Dustbin Number : " + currentID;
                            String text = "The dustbin status delay for the dustbin number :" + currentID + " has crossed the given threshold of " + landing.vanResponseDelay + "mins.";
                            obj.send(email_from, password, email_to, sub, text);
                            qu_update = "UPDATE DUSTBIN SET isMailSentToAuthority = true WHERE ID = '" + currentID +"'";
                            if(landing.databaseHandler.execAction(qu_update)){
                                //Add Log
                                ts = new Timestamp(System.currentTimeMillis());
                                log = ts + " : Mail sent to the authority notifying that dustbin status has been delayed for the dustbin: " + currentID + "\n";
                                landing.logReport += log;
                            }
                        }
                        
                    }else if(rs_dustbin.getInt("delay") != 0){
                        qu_update = "UPDATE DUSTBIN SET isMailSentToAuthority = false, isFull = false, isMailSentToVan = false, delay = 0 WHERE ID = '" + currentID +"'";
                        if(landing.databaseHandler.execAction(qu_update)){
                            //Add Log - bin has been emptied
                            ts = new Timestamp(System.currentTimeMillis());
                            log = ts + " : Dustbin: " + currentID + " has been emptied. \n";
                            landing.logReport += log;
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(SensorUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SensorUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
