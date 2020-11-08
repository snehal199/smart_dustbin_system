/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
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
        for (Map.Entry<String, Dustbin> entry : landing.dustbin.entrySet()) {
            //System.out.println(entry.getKey() + " = " + entry.getValue());
            Random rand = new Random(); 
            
            entry.getValue().sensedMoisture = rand.nextDouble()*100; 
            entry.getValue().sensedGarbageDepth = rand.nextDouble()*100; 
            //System.out.println(entry.getKey() + " values updated.\tMoisture: " + entry.getValue().sensedMoisture + "\tGarbage Depth: " + entry.getValue().sensedGarbageDepth);
            
            if(entry.getValue().sensedGarbageDepth >= landing.ultrasonicThreshold){
                //System.out.println(entry.getValue().ID + " is full!");
                entry.getValue().full = true;
                String van_key = Integer.toString(vanID);
                if(!landing.van.containsKey(van_key))
                	vanID = 0;
                van_key = Integer.toString(vanID);
                //System.out.println(landing.van.get("0").email);
                String email_to = landing.van.get(van_key).email;
                String sub = "Dustbin number : " + entry.getValue().ID + " is full" ;
                String text = "Dustbin number : " + entry.getValue().ID + " has reached the threshold of " + landing.ultrasonicThreshold + "cm. Clean it as soon as possible.";
                obj.send(email_from, password, email_to, sub, text);
                vanID++;
            }else
                entry.getValue().full = false;
            
            //Do this part better!
            //To check delay status
            if(entry.getValue().full){
                entry.getValue().delay++;
                
                if(entry.getValue().delay > landing.dustbinStatusDelay){
                    String email_to = "iit2019171@iiita.ac.in";
                    String sub = "Delay in cleaning of Dustbin Number : " + entry.getValue().ID;
                    String text = "The dustbin status delay for the dustbin number :" + entry.getValue().ID + " has crossed the given threshold of " + landing.dustbinStatusDelay + "mins.";
                    obj.send(email_from, password, email_to, sub, text);
                }
            }else{
                entry.getValue().delay = 0;
            }
        }
    }
    
}
