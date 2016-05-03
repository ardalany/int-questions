/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Arrays;

import Console.*;

/**
 *
 * @author Ardalan
 */
public class UniqueChars implements Runnable {
    
    private final OneLineReader _reader;
    private final OneLineWriter _writer;
    
    public UniqueChars(){
        _reader = new OneLineReader();
        _writer = new OneLineWriter();
    }
    
    @Override
    public void run(){
        _writer.write("Enter a string to check if it has unique characters:");
        String input = _reader.read();

        if(hasUniqueChars(input)){
            _writer.write("It is unique!");
        }
        else{
            _writer.write("It is NOT unique :(");
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
