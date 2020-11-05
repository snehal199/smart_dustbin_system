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
    double sensedMoisture;              //in percentage
    double sensedGarbageDepth;          //in centimeters
    String moisture;                    //stores dry/wet status
    boolean full;                      //true/false for full status
    int delay=0;
}
