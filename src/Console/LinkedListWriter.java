/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import LinkedList.*;
import java.util.ArrayList;

/**
 *
 * @author Ardalan
 */
public class LinkedListWriter<T> {
    private final OneLineWriter _writer;
    
    public LinkedListWriter(){
        _writer = new OneLineWriter();
    }
    
    public void write(LinkedList<T> list){
        ArrayList<String> nodeValues = new ArrayList<>();
        
        LinkedListNode<T> currentNode = list.head;
        
        while(currentNode != null){
            if(currentNode.data != null){
                nodeValues.add(currentNode.data.toString());
            }
            
            currentNode = currentNode.next;
        }
        
        _writer.write(String.join(", ", nodeValues));
    }
}
