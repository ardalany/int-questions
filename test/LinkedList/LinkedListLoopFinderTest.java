/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ardalan
 */
public class LinkedListLoopFinderTest {
    
    public LinkedListLoopFinderTest() {
    }

    @Test
    public void HasALoop_returns_false_with_an_empty_loop() {
        // Set up
        LinkedList<Integer> list = new LinkedList<>();
        LinkedListLoopFinder instance = new LinkedListLoopFinder();
        
        // Execute
        boolean result = instance.HasLoop(list);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void HasALoop_returns_false_when_the_list_has_no_loop() {
        // Set up
        LinkedList<Integer> list = new LinkedList<>(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);
        
        LinkedListLoopFinder instance = new LinkedListLoopFinder();
        
        // Execute
        boolean result = instance.HasLoop(list);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void HasALoop_returns_true_when_the_list_has_a_loop() {
        // Set up
        LinkedList<Integer> list = CreateLinkedListWithALoop();
        
        LinkedListLoopFinder instance = new LinkedListLoopFinder();
        
        // Execute
        boolean result = instance.HasLoop(list);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void GetLoopLength_returns_zero_when_the_list_has_no_loop(){
        // Set up
        LinkedList<Integer> list = new LinkedList<>();
        
        LinkedListLoopFinder instance = new LinkedListLoopFinder();
        
        // Execute
        int result = instance.GetLoopLength(list);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    public void GetLoopLength_returns_loop_length_when_the_list_has_a_loop(){
        // Set up
        LinkedList<Integer> list = CreateLinkedListWithALoop();
        
        LinkedListLoopFinder instance = new LinkedListLoopFinder();
        
        // Execute
        int result = instance.GetLoopLength(list);
        
        // Assert
        assertEquals(6, result);
    }
    
    @Test
    public void GetLoopStartingNode_returns_null_when_the_list_has_no_loop(){
        // Set up
        LinkedList<Integer> list = new LinkedList<>();
        
        LinkedListLoopFinder instance = new LinkedListLoopFinder();
        
        // Execute
        LinkedListNode<Integer> result = instance.GetLoopStartingNode(list);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void GetLoopStartingNode_returns_loop_first_node_when_the_list_has_a_loop(){
        // Set up
        LinkedList<Integer> list = CreateLinkedListWithALoop();
        
        LinkedListLoopFinder instance = new LinkedListLoopFinder();
        
        // Execute
        LinkedListNode<Integer> result = instance.GetLoopStartingNode(list);
        
        // Assert
        assertEquals(4, (int)result.data);
    }
    
    private LinkedList<Integer> CreateLinkedListWithALoop(){
        LinkedList<Integer> list = new LinkedList<>(1);
        
        LinkedListNode currentNode = list.head;
        currentNode.next = new LinkedListNode(2);
        currentNode = currentNode.next;
        
        currentNode.next = new LinkedListNode(3);
        currentNode = currentNode.next;
        
        LinkedListNode loopStart = new LinkedListNode(4);
        currentNode.next = loopStart;
        currentNode = currentNode.next;
        
        currentNode.next = new LinkedListNode(5);
        currentNode = currentNode.next;
        
        currentNode.next = new LinkedListNode(6);
        currentNode = currentNode.next;
        
        currentNode.next = new LinkedListNode(7);
        currentNode = currentNode.next;
        
        currentNode.next = new LinkedListNode(8);
        currentNode = currentNode.next;
        
        currentNode.next = new LinkedListNode(9);
        currentNode = currentNode.next;
        
        currentNode.next = loopStart;
        
        return list;
    }
}
