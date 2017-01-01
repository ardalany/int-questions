/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Console.*;
import Exception.StackTraceParser;

/**
 *
 * @author Ardalan
 */
public class PalindromeVerifier implements Runnable {

    private final LinkedListReader<String> _linkedListReader;
    private final OneLineWriter _oneLineWriter;

    public PalindromeVerifier() {
        _linkedListReader = new LinkedListReader<>(String.class);
        _oneLineWriter = new OneLineWriter();
    }

    private boolean isPalindrome(LinkedList<String> list) {
        boolean isPalindrome = true;

        LinkedListNode currentNode = list.head;

        LinkedListNode reverseCurrentNode = null;
        LinkedListNode reversePreviousNode = new LinkedListNode<>();

        int length = 0;
        while (currentNode != null) {
            reverseCurrentNode = reversePreviousNode;
            reverseCurrentNode.data = currentNode.data;
            reversePreviousNode = new LinkedListNode<>();
            reversePreviousNode.next = reverseCurrentNode;

            currentNode = currentNode.next;
            length++;
        }

        currentNode = list.head;
        for (int i = 1; i <= (length / 2); i++) {
            if (!currentNode.data.equals(reverseCurrentNode.data)) {
                isPalindrome = false;
                break;
            }

            currentNode = currentNode.next;
            reverseCurrentNode = reverseCurrentNode.next;
        }

        return isPalindrome;
    }

    @Override
    public void run() {
        try {
            LinkedList list = _linkedListReader.read();

            boolean isPalindrome = isPalindrome(list);
            
            _oneLineWriter.write(Boolean.toString(isPalindrome));
        } catch (Exception ex) {
            _oneLineWriter.write("Exception: " + ex.getMessage());
            _oneLineWriter.write(new StackTraceParser().getStackTrace(ex));
        }
    }

}
