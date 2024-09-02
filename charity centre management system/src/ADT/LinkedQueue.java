
package ADT;

import java.util.Iterator;

public class LinkedQueue<T> implements LinkedQueueInterface<T> {
    private Node front;  // Front of the queue
    private Node rear;   // Rear of the queue
    private int size;       // Number of elements in the queue

    // Constructor to create an empty queue
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Check if the queue is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the queue
    @Override
    public int getSize() {
        return size;
    }

    // Add an element to the rear of the queue (enqueue)
    @Override
    public void enqueue(T newData) {
        Node newNode = new Node(newData); // Create a new node
        if (isEmpty()) {
            front = rear = newNode; // If empty, front and rear are the same
        } else {
            rear.next = newNode;    // Link the new node to the end of the queue
            rear = newNode;         // Update the rear pointer
        }
        size++;  // Increment the size
    }

    // Remove an element from the front of the queue (dequeue)
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;    // Get the data from the front node
        front = front.next;     // Move the front pointer to the next node
        if (front == null) {
            rear = null;        // If the queue is now empty, rear should also be null
        }
        size--;  // Decrement the size
        return data;
    }

    // Get the front element without removing it (peek)
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // Clear the queue
    @Override
    public void clear() {
        front = rear = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = front;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }
    
    @Override
    public Iterator<T> getIterator() {
    return new LinkedQueueIterator();
  }

  private class LinkedQueueIterator implements Iterator<T> {

    private Node currentNode;

    public LinkedQueueIterator() {
      currentNode = front;
    }

    public boolean hasNext() {
      return currentNode != null;
    }

    public T next() {
      if (hasNext()) {
        T returnData = currentNode.data;
        currentNode = currentNode.next;
        return returnData;
      } else {
        return null;
      }
    }
  }
    private class Node {

    private T data; 
    private Node next; 

    private Node(T data) {
      this.data = data;
      this.next = null;
    } 

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    } 
  } 
}
