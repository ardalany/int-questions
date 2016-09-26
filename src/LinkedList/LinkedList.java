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
public class LinkedList<T> {

    public LinkedListNode<T> head;

    public LinkedList(T headValue) {
        head = new LinkedListNode<>(headValue);
    }
    
    public LinkedList(){
        head=new LinkedListNode<>();
    }

    public void appendToTail(T value) {
        LinkedListNode<T> node = head;

        while (node.next != null) {
            node = node.next;
        }

        node.next = new LinkedListNode<>(value);
    }

    /**
     * Deletes the first occurrence of the node with the given value.
     *
     * @param value the value of the node to be deleted from the list
     */
    public void deleteNode(T value) {

        if (head.data == value) {
            head = head.next;
        } else {
            LinkedListNode<T> currentNode = head;

            while (currentNode.next != null && currentNode.next.data != value) {
                currentNode = currentNode.next;
            }

            // Node was found. Delete it
            if (currentNode.next != null) {
                LinkedListNode<T> nodeToDelete = currentNode.next;

                currentNode.next = nodeToDelete.next;
            }
            else{
                throw new IndexOutOfBoundsException("a new with the provided value was not found.");
            }
        }

    }
}
