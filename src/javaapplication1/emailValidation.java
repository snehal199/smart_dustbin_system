/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Snehalreet
 */
public class emailValidation {
    public static boolean emailValidation(String email){
        boolean status = false;
        
        String email_Pattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        
        Pattern pattern = Pattern.compile(email_Pattern);
        Matcher matcher = pattern.matcher(email);
        
        if(matcher.matches()){
            status = true;
        }
        else
        {
            status = false;
        }
        
        return status;
    }
}
