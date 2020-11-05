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
        //System.out.println("Timer task executed.");
        
        //Loop through the database and update the values in the local hashMap landing.dustbin
        
        //For now, updating the sensor values in the hashmap with random values
        
        for (Map.Entry<String, Dustbin> entry : landing.dustbin.entrySet()) {
            //System.out.println(entry.getKey() + " = " + entry.getValue());
            Random rand = new Random(); 
            
            entry.getValue().sensedMoisture = rand.nextDouble()*100; 
            entry.getValue().sensedGarbageDepth = rand.nextDouble()*100; 
            //System.out.println(entry.getKey() + " values updated.\tMoisture: " + entry.getValue().sensedMoisture + "\tGarbage Depth: " + entry.getValue().sensedGarbageDepth);
            
            if(entry.getValue().sensedGarbageDepth >= landing.ultrasonicThreshold){
                //System.out.println(entry.getValue().ID + " is full!");
                entry.getValue().full = true;
                //SEND MAIL
            }else
                entry.getValue().full = false;
            
            //Do this part better!
            //To check delay status
            if(entry.getValue().full){
                entry.getValue().delay++;
                
                if(entry.getValue().delay > landing.dustbinStatusDelay){
                    //Send mail to authority
                }
            }else{
                entry.getValue().delay = 0;
            }
        }
    }
    
}
