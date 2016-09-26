/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Console.*;
import Exception.*;
import java.util.*;

/**
 *
 * @author Ardalan
 */
public class LinkedListDuplicateRemover implements Runnable {

    private final LinkedListReader<String> _linkedListReader;
    private final LinkedListWriter<String> _linkedListWriter;
    private final OneLineWriter _oneLineWriter;

    public LinkedListDuplicateRemover() {
        _linkedListReader = new LinkedListReader<>(String.class);
        _linkedListWriter = new LinkedListWriter<>();
        _oneLineWriter = new OneLineWriter();
    }

    private void removeDuplicates(LinkedList<String> list) {
        HashSet<String> uniqueValues = new HashSet<>();

        LinkedListNode<String> previousNode = null;
        LinkedListNode<String> currentNode = list.head;

        while (currentNode != null) {
            if (!uniqueValues.contains(currentNode.data)) {
                uniqueValues.add(currentNode.data);
                previousNode = currentNode;
            } else {
                previousNode.next = currentNode.next;
            }

            currentNode = currentNode.next;
        }
    }

    @Override
    public void run() {
        try {
            LinkedList<String> list = _linkedListReader.read();

            removeDuplicates(list);

            _oneLineWriter.write("\nAfter removing duplicates:\n");
            _linkedListWriter.write(list);
        } catch (Exception ex) {
            _oneLineWriter.write("Exception: " + ex.getMessage());
            _oneLineWriter.write(new StackTraceParser().getStackTrace(ex));
        }
    }
}
