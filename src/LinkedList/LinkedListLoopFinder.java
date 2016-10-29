/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Ardalan
 */
public class LinkedListLoopFinder {
    private LinkedListNode<Integer> _slowPointer;
    private LinkedListNode<Integer> _fastPointer;
        
    public boolean HasLoop(LinkedList<Integer> list){
        _slowPointer = list.head;
        _fastPointer = list.head;
        
        boolean hasLoop = false;
        
        while(_fastPointer != null && _fastPointer.next != null && !hasLoop){
            // Move the slow pointer one node
            _slowPointer = _slowPointer.next;
            
            // Move the fast pointer two nodes
            _fastPointer = _fastPointer.next.next;
            
            // If they meet, a loop is found
            hasLoop = (_slowPointer == _fastPointer);
        }
        
        return hasLoop;
    }
    
    public int GetLoopLength(LinkedList<Integer> list){
        int length = 0;
        
        if(HasLoop(list)){
            // The pointers have met. Move the slow pointer until it meets the fast pointer again.
            do {
                _slowPointer = _slowPointer.next;
                length++;
            } while(_slowPointer != _fastPointer);
        }
        
        return length;
    }
    
    /**
     * Finds and returns the first node of a linked list's loop. 
     * @param list
     * @return The first node of the loop, or null If there is no loop.
     */
    public LinkedListNode<Integer> GetLoopStartingNode(LinkedList<Integer> list){
        if(HasLoop(list)){
            // The pointers have met. Move the slow pointer to the head of the list.
            _slowPointer = list.head;
            
            // Move both pointers one node at a time until they meet. That's where the loop starts.
            while(_slowPointer != _fastPointer){
                _slowPointer = _slowPointer.next;
                _fastPointer = _fastPointer.next;
            }
            
            return _slowPointer;
        }
        else{
            return null;
        }
    }
}
