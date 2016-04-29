/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strings;

import Console.*;
import Exception.*;

/**
 *
 * @author Ardalan
 */
public class ImageRotator implements Runnable{
    
    private final MatrixReader<Integer> _matrixReader;
    private final MatrixWriter<Integer> _matrixWriter;
    private final OneLineWriter _writer;
    
    public ImageRotator(){
        _matrixReader = new MatrixReader<>(Integer.class);
        _matrixWriter = new MatrixWriter<>();
        _writer = new OneLineWriter();
    }

    @Override
    public void run(){
        try {
            Integer[][] matrix = _matrixReader.read();
            
            _matrixWriter.write(matrix);
        } catch (Exception ex) {
            _writer.write("Exception: " + ex.getMessage());
            _writer.write(new StackTraceParser().getStackTrace(ex));
        }
    }
    
}
