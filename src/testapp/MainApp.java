package testapp;

import LinkedList.*;

/**
 *
 * @author Ardalan
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable runnable = new PalindromeVerifier();
        runnable.run();
    }
    
}
