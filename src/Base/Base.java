/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Base;
import java.util.Scanner;

/**
 *
 * @author Ardalan
 */
public abstract class Base implements Runnable {
    @Override
    public abstract void run();
    
    protected void write(String output){
        System.out.println(output);
    }
    
    protected String read(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        
        return input;
    }
}
