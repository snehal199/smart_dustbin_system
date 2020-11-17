/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

/**
 *
 * @author jyots
 */
public class Dustbin {
    String ID;
    String location;
    String dimension;
    double sensedMoisture = 45.0;              //in percentage
    double sensedGarbageDepth = 80.0;          //in centimeters
    String moisture = "Dry";                    //stores dry/wet status
    boolean full = false;                      //true/false for full status
    int delay=0;
    boolean isMailSentToVan = false;
    boolean isMailSentToAuthority = false;
    String mailSentToVanId = "";
}
