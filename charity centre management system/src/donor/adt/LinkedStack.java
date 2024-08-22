/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donor.adt;

/**
 *
 * @author Lenovo
 */
public class LinkedStack<T> implements StackInterface<T>{
    private class Node{
        T data;
        Node next;
        
        Node(T data){
            this.data= data;
            this.next = null;
        }
    }
    
    private Node top;
    private int size;
    
    public LinkedStack(){
        top = null;
        size =0;
    }
    
    public void push(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public T pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        T popElement = top.data;
        top = top.next;
        size--;
        return popElement;
    }
    
    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }
    public boolean isEmpty(){
        return top == null;
    }

    public int getSize() {
        return size;
    }
    
    
}
