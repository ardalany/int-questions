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

    private void partition(LinkedList<Integer> list, int value) {
        LinkedList<Integer> gteList = null;

        LinkedListNode<Integer> currentNode = list.head;

        // This reference will point to the last node of the original list when we exit the loop
        LinkedListNode<Integer> previousNode = null;

        //LinkedListNode<Integer> currentGteNode = gteList.head;
        LinkedListNode<Integer> currentGteNode = new LinkedListNode<>();

        while (currentNode != null) {
            if (currentNode.data >= value) {

                // Add the value to the greater than or equal to list
                if (gteList == null) {
                    gteList = new LinkedList<>(currentNode.data);
                    currentGteNode.next = gteList.head;
                } else {

                    currentGteNode.next = new LinkedListNode<>(currentNode.data);
                }
                currentGteNode = currentGteNode.next;

                // Delete element from original list
                if (currentNode.next != null) {
                    currentNode.data = currentNode.next.data;
                    currentNode.next = currentNode.next.next;

                    previousNode = currentNode;
                } else {
                    previousNode.next = null;
                }
            } else {
                previousNode = currentNode;
            }

            currentNode = currentNode.next;

        }

        // append the greater than or equal to list to the original list
        previousNode.next = gteList.head;
    }

    @Override
    public void run() {
        try {
            LinkedList<Integer> list = _linkedListReader.read();
            
            _oneLineWriter.write(("Enter a value to partition the linked list by:"));
            int value = Integer.parseInt(_oneLineReader.read());
            
            partition(list, value);

            _oneLineWriter.write("\nAfter partitioning by " + Integer.toString(value) + ":\n");
            _linkedListWriter.write(list);
        } catch (Exception ex) {
            _oneLineWriter.write("Exception: " + ex.getMessage());
            _oneLineWriter.write(new StackTraceParser().getStackTrace(ex));
        }
    }

}
