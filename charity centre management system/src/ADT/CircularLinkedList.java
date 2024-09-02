/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

/**
 *
 * @author Heng Wei Long
 * @param <T>
 */
public class CircularLinkedList<T> implements ListInterface<T> {
    
    // external pointer
    private Node lastNode;
    
    public CircularLinkedList(){
        lastNode = null;
    }
    
    public class Node{
        private final T data;
        private Node next;// pointer (connect)
        
        // constructor
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    
    // add newNode at the end of list
    @Override
    public boolean add(T newEntry){
        // create newNode
        Node newNode = new Node(newEntry);
        
        // when empty, inserting the first node to the list
        if (isEmpty()) { 
            // point first and last to newNode  1(1)
            lastNode = newNode;
            lastNode.next = lastNode;
        }
        // inseting to the list with existing items
        else { 
            // point lastNode.next = firstNode to newNode.next  // 4() -> 4(1)
            newNode.next = lastNode.next;
            // lastNode point to newNode    // 1(2), 2(3), 3(1) + 4(1): 3(4) + 4(1)
            lastNode.next = newNode;
            // newNode become last      // 1(2), 2(3), 3(4), 4(1)
            lastNode = newNode;
        }
        return true;
    }

    @Override
    public T getEntry(int givenPosition){
        T result = null;
        Node current = lastNode.next;
        if ((givenPosition >= 1) && (givenPosition <= getNumberOfEntries())) {
                givenPosition -= 1;
            while (givenPosition != 0) {
                givenPosition -= 1;
                current = current.next;
            }
            result = current.data;
        }
        return result;
    }
    
    // remove the group by the donationId
    @Override
    public T remove(T anEntry){
        T result = null;
        if(isEmpty()) {
            return result;
        }
        // Start with the first node
        Node current = lastNode.next;
        // The previous node start from last
        Node previous = lastNode;
        
        do {
            CircularLinkedList temp = (CircularLinkedList) current.data;

            // turn the data into integer
            int i = (Integer) temp.getEntry(1);
            if ( i == (Integer) anEntry) { //turn the input from T to integer
                // if the node is last node
                if (current == lastNode) {
                    // if the node only node
                    if (lastNode == lastNode.next) {
                        lastNode = null;
                    } 
                    // if not the only
                    else {
                        previous.next = current.next;
                        lastNode = previous;
                    }
                }
                else {
                    previous.next = current.next;
                }
                result = (T) temp.getEntry(1);
                return result;
            }
            // Update previous only after checking, to correctly track the previous node
            previous = current;
            current = current.next;
        } while (current != lastNode.next);
        
        return result;
    }
    
    // update the element input by replace the data
    @Override
    public boolean replace(int givenPosition, T newEntry){
        Node current = lastNode.next;
        Node previous = lastNode;
        Node newNode = new Node(newEntry);
        if ((givenPosition >= 1) && (givenPosition <= getNumberOfEntries())) {
                givenPosition -= 1;
            while (givenPosition != 0) {
                givenPosition -= 1;
                previous = current;
                current = current.next;
            }
            newNode.next = current.next;
            current = newNode;
            previous.next = current;
            return true;
        }
        return false;
    }
    
    // clear all by make the lastNode to null, so then all data will be drop
    @Override
    public void clear(){
        lastNode = null;
    }
    
    // count and get the number of a group of circular linked list
    @Override
    public int getNumberOfEntries(){
        if (isEmpty()) {
            return 0;
        }
        int num = 0;
        Node current = lastNode.next;
        do {
            num ++;
            current = current.next;
        } while (current != lastNode.next);
        
        return num;
    }
    
    // check the circular linked list is empty or not
    @Override
    public boolean isEmpty(){
        // if lastNode empty
        return lastNode == null;
    }

    @Override
    public boolean add(int newPosition, T newEntry){
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
    @Override
    public boolean contains(T anEntry){
        return false;
    }
}
