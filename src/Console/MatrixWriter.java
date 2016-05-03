/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;


public class MatrixWriter<T>{
    private final OneLineWriter _writer;
    
    public MatrixWriter(){
        _writer = new OneLineWriter();
    }
    
    public void write(T[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            String[] elements = new String[matrix[i].length];
            for(int j = 0; j < matrix[0].length; j++){
                elements[j]=matrix[i][j].toString();
            }
            
            _writer.write(String.join(",", elements));
        }
    }
    
}
