/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
import java.sql.Timestamp;
import java.util.*;

/**
 *
 * @author jyots
 */
public class SensorUpdate extends TimerTask {
    
    public void run(){
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
        
        for (Map.Entry<String, Dustbin> entry : landing.dustbin.entrySet()) {
            //System.out.println(entry.getKey() + " = " + entry.getValue());
            Random rand = new Random(); 
            
            entry.getValue().sensedMoisture = rand.nextDouble()*100; 
            entry.getValue().sensedGarbageDepth = rand.nextDouble()*100; 
            //System.out.println(entry.getKey() + " values updated.\tMoisture: " + entry.getValue().sensedMoisture + "\tGarbage Depth: " + entry.getValue().sensedGarbageDepth);
            
            if(entry.getValue().sensedGarbageDepth >= landing.ultrasonicThreshold){
                //System.out.println(entry.getValue().ID + " is full!");
                entry.getValue().full = true;
                entry.getValue().delay++;
                
                //Add Log
                ts = new Timestamp(System.currentTimeMillis());
                log = ts + " : Dustbin: " + entry.getValue().ID + " detected full.\n";
                landing.logReport += log;
                
                //Mailing
                if(!entry.getValue().isMailSentToVan){
                    String van_key = landing.vanID.get(landing.vanIDIndex);
                    /*
                    if(!landing.van.containsKey(van_key))
                        vanID = 0;
                    van_key = Integer.toString(vanID);
                            */
                    landing.vanIDIndex++;
                    if(landing.vanIDIndex >= landing.vanID.size())
                        landing.vanIDIndex = 0;
                    //System.out.println(landing.van.get("0").email);
                    String email_to = landing.van.get(van_key).email;
                    String sub = "Dustbin number : " + entry.getValue().ID + " is full" ;
                    String text = "Dustbin number : " + entry.getValue().ID + " placed at: " + entry.getValue().location + " has reached the threshold of " + landing.ultrasonicThreshold + "cm. Clean it as soon as possible.";
                    obj.send(email_from, password, email_to, sub, text);
                    entry.getValue().isMailSentToVan = true;
                    //entry.getValue().mailSentToVanId = van_key;
                    
                    //Add Log
                    ts = new Timestamp(System.currentTimeMillis());
                    log = ts + " : Mail sent to van: " + van_key + " To empty the dustbin: " + entry.getValue().ID + "\n";
                    landing.logReport += log;
                }
                
                if(!entry.getValue().isMailSentToAuthority && entry.getValue().delay*5 >= landing.vanResponseDelay){
                    //Send mail to authority
                    String email_to = "iit2019171@iiita.ac.in";
                    String sub = "Delay in cleaning of Dustbin Number : " + entry.getValue().ID;
                    String text = "The dustbin status delay for the dustbin number :" + entry.getValue().ID + " has crossed the given threshold of " + landing.dustbinStatusDelay + "mins.";
                    obj.send(email_from, password, email_to, sub, text);
                    entry.getValue().isMailSentToAuthority = true;
                    
                    //Add Log
                    ts = new Timestamp(System.currentTimeMillis());
                    log = ts + " : Mail sent to the authority notifying that dustbin status has been delayed for the dustbin: " + entry.getValue().ID + "\n";
                    landing.logReport += log;
                }
                
            }else if(entry.getValue().delay != 0){
                entry.getValue().full = false;
                entry.getValue().delay = 0;
                entry.getValue().isMailSentToVan = false;
                entry.getValue().isMailSentToAuthority = false;
                //entry.getValue().mailSentToVanId = "";
                
                //Add Log - bin has been emptied
                ts = new Timestamp(System.currentTimeMillis());
                log = ts + " : Dustbin: " + entry.getValue().ID + " has been emptied. \n";
                landing.logReport += log;
            }
            
        }
    }
    
}
