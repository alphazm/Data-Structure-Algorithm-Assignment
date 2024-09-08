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

    public CircularLinkedList() {
        lastNode = null;
    }

    public class Node {

        private final T data;
        private Node next;// pointer (connect)

        // constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // add newNode at the end of list
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            lastNode = newNode;
            lastNode.next = lastNode;
        }
        else {
            newNode.next = lastNode.next;
            lastNode.next = newNode;
            lastNode = newNode;
        }
        return true;
    }

    @Override
    public T getEntry(int givenPosition) {
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
    
    @Override
    public T remove(T anEntry) {
        int givenPosition = (int) anEntry;
        T result = null;
        // Check if the list is empty or the position is invalid
        if (isEmpty() || givenPosition < 1 || givenPosition > getNumberOfEntries()) {
            return result;
        }
        Node current = lastNode.next;
        Node previous = lastNode;
        if (givenPosition == 1) {
            result = (T) current.data;
            if (lastNode == lastNode.next) {
                lastNode = null;
            } else {
                previous.next = current.next;
                lastNode.next = current.next;
            }
        } else {
            for (int i = 1; i < givenPosition; i++) {
                previous = current;
                current = current.next;
            }
            result = (T) current.data;
            previous.next = current.next;
            if (current == lastNode) {
                lastNode = previous;
            }
        }
    return result;
}

    // update the element input by replace the data
    @Override
    public boolean replace(int givenPosition, T newEntry) {
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
    public void clear() {
        lastNode = null;
    }

    // count and get the number of a group of circular linked list
    @Override
    public int getNumberOfEntries() {
        if (isEmpty()) {
            return 0;
        }
        int num = 0;
        Node current = lastNode.next;
        do {
            num++;
            current = current.next;
        } while (current != lastNode.next);

        return num;
    }

    // check the circular linked list is empty or not
    @Override
    public boolean isEmpty() {
        // if lastNode empty
        return lastNode == null;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public void addinArray(T item) {
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void removeOut(int index) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void expandArray() {
    }

    @Override
    public void update(int index, T newItem) {
    }
}

