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
public class KthToLastLinkedListNodeRetriever implements Runnable {

    private final LinkedListReader<String> _linkedListReader;
    private final OneLineWriter _oneLineWriter;
    private final OneLineReader _oneLineReader;

    public KthToLastLinkedListNodeRetriever() {
        _linkedListReader = new LinkedListReader<>(String.class);
        _oneLineWriter = new OneLineWriter();
        _oneLineReader = new OneLineReader();
    }

    private LinkedListNode<String> getKthNodeFromLast(int k, LinkedList<String> list) throws IllegalArgumentException {
        if (k < 0) {
            throw new IllegalArgumentException("k must be greater than or equal to zero. Actual value: " + String.valueOf(k));
        }

        int count = 0;

        LinkedListNode<String> currentNode = list.head;

        while (currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }

        LinkedListNode<String> kthNodeFromLast = list.head;

        int i = 1;
        while(kthNodeFromLast.next != null && i <= (count - k)){
            kthNodeFromLast = kthNodeFromLast.next;
            i++;
        }

        return kthNodeFromLast;
    }

    @Override
    public void run() {
        try {
            LinkedList<String> list = _linkedListReader.read();

            _oneLineWriter.write("K? (kth node from last)");
            String k = _oneLineReader.read();

            LinkedListNode<String> kthNodeFromLast = getKthNodeFromLast(Integer.parseInt(k), list);

            if (kthNodeFromLast.data != null) {
                _oneLineWriter.write("The " + k + "th node from last is " + kthNodeFromLast.data);
            } else {
                _oneLineWriter.write("The " + k + "th node from last does not have a value.");
            }
        } catch (Exception ex) {
            _oneLineWriter.write("Exception: " + ex.getMessage());
            _oneLineWriter.write(new StackTraceParser().getStackTrace(ex));
        }
    }
}
