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
public class MatrixZeroer implements Runnable {
    private final MatrixReader<Integer> _matrixReader;
    private final MatrixWriter<Integer> _matrixWriter;
    private final OneLineWriter _writer;
    
    public MatrixZeroer(){
        _matrixReader = new MatrixReader<>(Integer.class);
        _matrixWriter = new MatrixWriter<>();
        _writer = new OneLineWriter();
    }
    
    @Override
    public void run(){
        try {
            Integer[][] matrix = _matrixReader.read();
            
            _writer.write("\nBefore modification:\n");
            _matrixWriter.write(matrix);
            
            int rowCount = matrix.length;
            int columnCount = matrix[0].length;
            
            boolean[] zeroRows = new boolean[rowCount];
            boolean[] zeroColumns = new boolean[columnCount];
            
            for(int i = 0; i < rowCount; i++){
                for(int j = 0; j < columnCount; j++){
                    if(matrix[i][j] == 0){
                        zeroRows[i] = true;
                        zeroColumns[j] = true;
                    }
                }
            }
            
            for(int i = 0; i < rowCount; i++){
                for(int j = 0; j < columnCount; j++){
                    if(zeroRows[i] == true || zeroColumns[j] == true){
                        matrix[i][j] = 0;
                    }
                }
            }
            
            _writer.write("\nAfter modification:\n");
            _matrixWriter.write(matrix);
            
        } catch (Exception ex) {
            _writer.write("Exception: " + ex.getMessage());
            _writer.write(new StackTraceParser().getStackTrace(ex));
        }
    }
}
