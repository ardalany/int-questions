/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Strings;

import Base.*;

/**
 *
 * @author Ardalan
 */
public class UniqueChars extends Base {
    @Override
    public void run(){
        write("Enter a string to check if it has unique characters:");
        String input = read();

        if(hasUniqueChars(input)){
            write("It is unique!");
        }
        else{
            write("It is NOT unique :(");
        }
    }
    
    private boolean hasUniqueChars(String s){
        if(s.length() > 256){
            return false;
        }
        
        char[] chars=s.toCharArray();
        boolean[] hasChar = new boolean[256];
        
        for(char c : chars){
            int ascii=(int)c;
            if(hasChar[ascii]){
                return false;
            }
            else{
                hasChar[ascii]=true;
            }
        }
        
        return true;
    }
}
