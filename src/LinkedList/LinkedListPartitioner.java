/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Console.*;
import Exception.*;

/**
 *
 * @author Ardalan
 */
public class LinkedListPartitioner implements Runnable {

    private final LinkedListReader<Integer> _linkedListReader;
    private final LinkedListWriter<Integer> _linkedListWriter;
    private final OneLineWriter _oneLineWriter;
    private final OneLineReader _oneLineReader;

    public LinkedListPartitioner() {
        _linkedListReader = new LinkedListReader<>(Integer.class);
        _linkedListWriter = new LinkedListWriter<>();
        _oneLineWriter = new OneLineWriter();
        _oneLineReader = new OneLineReader();
    }

    private LinkedList<Integer> partition(LinkedList<Integer> list, int value) {
        LinkedList<Integer> ltList = null;
        LinkedList<Integer> gteList = null;
        
        LinkedListNode<Integer> currentNode = list.head;
        LinkedListNode<Integer> currentLtNode = null;
        LinkedListNode<Integer> currentGteList = null;
        
        while(currentNode != null){
            if(currentNode.data >= value){
                if(gteList == null){
                    gteList=new LinkedList<>(currentNode.data);
                    currentGteList = gteList.head;
                }
                else{
                    currentGteList.next = new LinkedListNode<>(currentNode.data);
                    currentGteList = currentGteList.next;
                }
            }
            else{
                if(ltList == null){
                    ltList=new LinkedList<>(currentNode.data);
                    currentLtNode = ltList.head;
                }
                else{
                    currentLtNode.next = new LinkedListNode<>(currentNode.data);
                    currentLtNode = currentLtNode.next;
                }
            }
            
            currentNode = currentNode.next;
        }
        
        if(ltList == null){
            return gteList;
        }
        else{
            if(gteList!=null){
                currentLtNode.next = gteList.head;
            }
            
            return ltList;
        }
    }

    @Override
    public void run() {
        try {
            LinkedList<Integer> list = _linkedListReader.read();
            
            _oneLineWriter.write(("Enter a value to partition the linked list by:"));
            int value = Integer.parseInt(_oneLineReader.read());
            
            LinkedList<Integer> partionedList = partition(list, value);

            _oneLineWriter.write("\nAfter partitioning by " + Integer.toString(value) + ":\n");
            _linkedListWriter.write(partionedList);
        } catch (Exception ex) {
            _oneLineWriter.write("Exception: " + ex.getMessage());
            _oneLineWriter.write(new StackTraceParser().getStackTrace(ex));
        }
    }

}
