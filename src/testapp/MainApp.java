package testapp;

import Strings.*;

/**
 *
 * @author Ardalan
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable runnable = new ImageRotator();
        runnable.run();
    }
    
}
