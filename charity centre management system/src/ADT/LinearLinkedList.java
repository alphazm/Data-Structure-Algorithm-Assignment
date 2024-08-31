/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

/**
 *
 * @author ChanWinYit
 */
public class LinearLinkedList<T> implements ListInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    private class Node {
        private T data;
        private Node next;
        
        private Node(T data){
            this.data=data;
            this.next= null;
        }
        private Node(T data, Node next){
            this.data=data;
            this.next=next;
        }
    }
    public LinearLinkedList(){
        clear();
    }
    
    @Override
    public final void clear(){
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
         Node newNode = new Node(newEntry);
         
         if(isEmpty()){
             firstNode=newNode;
         }
         else
         {
             Node currentNode = firstNode;
             while(currentNode.next != null){
                 currentNode = currentNode.next;
             }
             currentNode.next = newNode;
         }
         numberOfEntries++;
         return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;
        
        if((newPosition >=1)&&(newPosition<= numberOfEntries +1)){
            Node newNode = new Node(newEntry);
            
            if(isEmpty()|| (newPosition == 1)){
                newNode.next = firstNode;
            }
            else{
                Node nodeBefore = firstNode;
                for( int i=1;i< newPosition-1; ++i){
                    nodeBefore = nodeBefore.next;
                }
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;
            }
            numberOfEntries++;
        }
        else{
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T remove(T anEntry) {
        int givenPosition = (Integer) anEntry;
        T result = null;
        if((givenPosition >=1)&&(givenPosition<=numberOfEntries)){
            if(givenPosition == 1){
                result = firstNode.data;
                firstNode = firstNode.next;
            }
            else{
                Node nodeBefore = firstNode;
                for(int i = 1; i< givenPosition -1; ++i){
                    nodeBefore = nodeBefore.next;
                }
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            }
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if((givenPosition >=1)&& (givenPosition <=numberOfEntries)){
            Node currentNode = firstNode;
            for (int i=0; i< givenPosition -1; ++i){
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        }
        else{
            isSuccessful =false;
        }
        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if((givenPosition >=1)&&(givenPosition <= numberOfEntries)){
            Node currentNode = firstNode;
            for(int i= 0;i<givenPosition -1;++i){
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        
        while(!found && (currentNode !=null)){
            if(anEntry.equals(currentNode.data)){
                found = true;
            }
            else{
                currentNode =currentNode.next;
            }
        }
        return found;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}

