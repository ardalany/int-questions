/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import LinkedList.LinkedListNode;



/**
 *
 * @author Ardalan
 */
public class Queue<T> {
    private LinkedListNode<T> _head;
    private LinkedListNode<T> _tail;
 
    
    public void enqueue(T value){
        if(_head == null){
            _head = new LinkedListNode<>(value);
            _tail = _head;
        }
        else{
            _tail.next = new LinkedListNode<>(value);
            _tail = _tail.next;
        }
    }
    
    public T dequeue(){
        if(_head != null){
            T data = _head.data;
            _head = _head.next;
            
            return data;
        }
        
        return null;
    }
}
