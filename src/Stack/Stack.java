/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import LinkedList.LinkedListNode;
import java.util.EmptyStackException;

/**
 *
 * @author Ardalan
 */
public class Stack<T> {

    private LinkedListNode<T> _top;

    public void push(T value) {
        if (_top == null) {
            _top = new LinkedListNode<>(value);
        } else {
            LinkedListNode<T> newNode = new LinkedListNode<>(value);
            newNode.next = _top;
            _top = newNode;
        }
    }

    public T pop() {
        if (_top == null) {
            return null;
        } else {
            T data = _top.data;
            _top = _top.next;

            return data;
        }
    }
    
    public T peek() {
        if (_top == null) {
            return null;
        } else {
            return _top.data;
        }
    }
}
