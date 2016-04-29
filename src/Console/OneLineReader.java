/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Console;
import java.util.Scanner;

/**
 *
 * @author Ardalan
 */
public class OneLineReader{
    private final Scanner _scanner;
    
    public OneLineReader(){
        _scanner=new Scanner(System.in); 
    }
    
    public String read(){
        String input = _scanner.nextLine();

        return input;
    }
    
    @Override
    protected void finalize() throws Throwable{
        try{
            _scanner.close();
        }catch(Exception ex){
            super.finalize();
        }
    }
}
