/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.lang.reflect.Array;

/**
 *
 * @author Ardalan
 */
public class MatrixReader<T> {
    private final OneLineReader _reader;
    private final OneLineWriter _writer;
    private final Class<T> _classType;
    
    public MatrixReader(Class<T> classType){
        _reader = new OneLineReader();
        _writer = new OneLineWriter();
        _classType = classType;
    }
    
    public T[][] read() throws Exception{
        _writer.write("Enter the number of rows:");
        int rowCount = Integer.parseInt(_reader.read());
        
        _writer.write("Enter the number of columns:");
        int columnCount = Integer.parseInt(_reader.read());
        
        T[][] matrix = (T[][])Array.newInstance(_classType, rowCount, columnCount);
        
        for(int i = 0; i < rowCount; i++){
            _writer.write("Enter the matrix, row by row, elements separated by comma (no space):");
            
            String input=_reader.read();
            String[] rowElements=input.split(",");
            
            if(rowElements.length != columnCount){
                throw new Exception("Each row must have " + Integer.toString(columnCount) + "elements.");
            }
            else{
                for(int j = 0; j < rowElements.length;j++){
                    matrix[i][j] = parse(rowElements[j]);
                }
            }
        }
        
        return matrix;
    }
    
    private T parse(String stringValue) throws Exception{
        return _classType.getConstructor(new Class[] {String.class }).newInstance(stringValue);
    }
}
