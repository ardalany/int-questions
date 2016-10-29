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
 * @author ayousefi
 */
public class Summation implements Runnable {
    private final LinkedListReader<Integer> _linkedListReader;
    private final LinkedListWriter<Integer> _linkedListWriter;
    private final OneLineWriter _oneLineWriter;
    
    public Summation(){
        _linkedListWriter = new LinkedListWriter<>();
        _linkedListReader = new LinkedListReader<>(Integer.class);
        _oneLineWriter = new OneLineWriter();
    }
    
    private LinkedList<Integer> calculateReverse(LinkedList<Integer> number1, LinkedList<Integer> number2){
        LinkedList<Integer> sum = new LinkedList<>();
        
        LinkedListNode<Integer> currentNumber1Node = number1.head;
        LinkedListNode<Integer> currentNumber2Node = number2.head;
        LinkedListNode<Integer> currentSumNode = sum.head;
        
        int carry = 0;
        while(currentNumber1Node != null || currentNumber2Node != null){
            int digitSum = carry;
            
            if(currentNumber1Node != null){
                digitSum += currentNumber1Node.data;
            } 
            if(currentNumber2Node != null){
                digitSum += currentNumber2Node.data;
            }
            
            if(digitSum > 9){
                carry = 1;
            }else{
                carry = 0;
            }
            
            currentSumNode.data = (digitSum % 10);
            currentSumNode.next = new LinkedListNode<>();
            
            currentSumNode = currentSumNode.next;
            
            if(currentNumber1Node != null){
                currentNumber1Node = currentNumber1Node.next;
            }
            
            if(currentNumber2Node != null){
                currentNumber2Node = currentNumber2Node.next;
            }
        }
        
        if(carry == 1) {
            currentSumNode.data = 1;
        }
        
        return sum;
    }

    @Override
    public void run() {
        try{
            _oneLineWriter.write("Number 1: (enter digits from right to left)");
            LinkedList<Integer> number1 = _linkedListReader.read();
            
            _oneLineWriter.write("Number 2: (enter digits from right to left)");
            LinkedList<Integer> number2 = _linkedListReader.read();
            
            LinkedList<Integer> sum = calculateReverse(number1, number2);
            
            _oneLineWriter.write("Sum:");
            _linkedListWriter.write(sum);
            
        } catch (Exception ex) {
            _oneLineWriter.write("Exception: " + ex.getMessage());
            _oneLineWriter.write(new StackTraceParser().getStackTrace(ex));
        }
    }
}
