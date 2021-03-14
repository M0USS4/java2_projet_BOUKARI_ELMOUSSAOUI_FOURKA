/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class CheckInputdata {

    
    //check email formate return true if email is correct
public static boolean checkEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
//check string and number if it is number return true if its string return false
public static boolean checkNumberOrString(String number){

    boolean isValid = true;
    char[] chars = number.toCharArray();
      for(char c : chars){
         if(Character.isAlphabetic(c)){
            isValid = false;
         }
      }
      return isValid;
    }

public boolean isValidDate(String dateStr) {
	
    DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    sdf.setLenient(false);
    try {
        sdf.parse(dateStr);
    } catch (ParseException e) {
        return false;
    }
    return true;
}  
    public static void main(String args[]) {
    	
    	CheckInputdata c = new CheckInputdata();
    	boolean s = c.isValidDate("10-13-2020");
    	
    	System.out.println(s);
    }
}
