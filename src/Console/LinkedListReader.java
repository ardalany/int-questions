/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import LinkedList.LinkedList;

/**
 *
 * @author Ardalan
 */
public class LinkedListReader<T> extends BaseReader<T> {
    
    public LinkedListReader(Class<T> classType) {
        super(classType);
    }
    
    public LinkedList<T> read() throws Exception{
        _writer.write("Enter the values of the linked list nodes, starting from head to tail. Separate nodes with a comma: ");
        String input = _reader.read();
        
        String[] values=input.split(",");
        
        if(values.length == 0){
            return new LinkedList<T>(null);
        }
        else{
            // Create the linked list with the head value
            LinkedList<T> list=new LinkedList<>(parse(values[0]));
            
            // Add the rest of the values to the list
            for(int i = 1; i < values.length; i++){
                list.appendToTail(parse(values[i]));
            }
            
            return list;
        }
    }
}
