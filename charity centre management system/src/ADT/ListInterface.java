/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADT;

/**
 *
 * @author Heng Wei Long
 */
public interface ListInterface<T> {
    public void add(T newEntry);
    public void displayAll();
    public void display();
    public T getFirst();
    public CircularLinkedList search(T entryType,T anEntry);
    public CircularLinkedList filter(T anEntry);
    public boolean remove(T anEntry);
    public void removeLast();
    public void clear();
    public void replace(T newEntry);
    public void replace(T oldEntry, T newEntry);
    public int getNumElement();
    public boolean isEmpty();
}
