/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

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
            
            _writer.write("\nBefore rotation:\n");
            _matrixWriter.write(matrix);
            
            int size = matrix.length;
            
            for(int offset = 0; offset < (size / 2); offset++){
                for(int row = offset; row <= (size - 1 - offset - 1); row++){
                    int temp = matrix[row][offset];
                    matrix[row][offset] = matrix[size - 1 - offset][row];
                    matrix[size - 1 - offset][row] = matrix[size - 1 - row][size - 1 - offset];
                    matrix[size - 1 - row][size - 1 - offset] = matrix[offset][size - 1 - row];
                    matrix[offset][size - 1 - row] = temp;
                }
                
                _writer.write("\nPass " + Integer.toString(offset) + "\n");
                _matrixWriter.write(matrix);
            }
        } catch (Exception ex) {
            _writer.write("Exception: " + ex.getMessage());
            _writer.write(new StackTraceParser().getStackTrace(ex));
        }
    }
    
}
