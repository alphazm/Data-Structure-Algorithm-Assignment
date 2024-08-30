/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

import Entity.Donation;

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

    // get the first node data --> donation id/ first donation
    @Override
    public T getEntry(int givenPosition){
        T result = null;
        Node current = lastNode.next;
        if ((givenPosition >= 1) && (givenPosition <= getNumElement())) {
                givenPosition -= 1;
            while (givenPosition != 0) {
                givenPosition -= 1;
                current = current.next;
            }
            result = current.data;
        }
        return result;
    }
    
    // search by donationId
    public T search(T entryType,T anEntry){
        if (isEmpty()) {
            System.out.println("The List Is Empty!");
            return null;
        }
        CircularLinkedList result = new CircularLinkedList();
        Node current = lastNode.next;
        int num = 1;
        do {
            // first donation of list
            CircularLinkedList temp = (CircularLinkedList) current.data;
            if (((String) entryType).equals("donationId")){
                // get donation id of donation
                int i = (Integer) temp.getEntry(1);
                if (i == (Integer) anEntry) {
                    return (T) temp;
                }
            }
            else if (((String) entryType).equals("category")) {
                // get donation's category from donation, every lastNode is donation, lastNode.next is donationId
                Donation donation = (Donation) temp.lastNode.data;
                String j = donation.getDonationCategory();
                if (j.equals((String) anEntry)) {
                    // if match add the donation to list
                    result.add(current.data);
                }
            }
            current = current.next;
        } while (current != lastNode.next);
        
        if (((String) entryType).equals("category")) {
            return (T) result;
        }
        return null;
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
                System.out.println(temp.getEntry(1));
                //System.out.println(); // display remove data

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
    public boolean replace(T entryType, T newEntry){
        // ori lastNode(donation)
        Donation oriDonation = (Donation) lastNode.data;
        Node current = lastNode.next.next; // donorId
        Node previous = lastNode.next; // donationId
        
        switch(((String) entryType)){
            case "donorId":
                // make entry become node
                Node newNode = new Node(newEntry);
                // replace data
                newNode.next = current.next;
                current = newNode;
                previous.next = current;
                break;
            case "itemCate":
                oriDonation.setDonationCategory((String) newEntry);
                break;
            case "itemDes":
                oriDonation.setItemDescription((String) newEntry);
                break;
            case "itemQty":
                oriDonation.setItemQuantity((Integer) newEntry);
                break;
            case "amount":
                oriDonation.setAmount((double) newEntry);
                break;
        }
        remove((T) "3");
        add((T) oriDonation);
        return true;
    }
    
//    public void replace(T newEntry){
//        Node current = lastNode.next;
//        Node previous = lastNode;
//        Node newNode = (Node) newEntry;
//        
//        // old donation
//        CircularLinkedList donation = (CircularLinkedList) newEntry;
//        // old donationId & donation details
//        int id = (Integer) donation.getEntry(1);
//
//        do {
//            // to catch out the old donation position 
//            CircularLinkedList temp = (CircularLinkedList) current.data;        
//
//            if ((Integer) temp.getEntry(1) == id) {
//                newNode.next = current.next;
//                current = newNode;
//                previous.next = current;
//            }
//            previous = current;
//            current = current.next;
//        } while (current != lastNode.next);
//    }
    
    // clear all by make the lastNode to null, so then all data will be drop
    @Override
    public void clear(){
        lastNode = null;
    }
    
    // count and get the number of a group of circular linked list
    @Override
    public int getNumElement(){
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
    public int getNumberOfEntries() {
        return 0;
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
