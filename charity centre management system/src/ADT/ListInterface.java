
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
    public T search(T entryType,T anEntry);
    public T filter(T anEntry);
    public T filter(T entryType, T anEntry);
    public boolean remove(T anEntry);
    public void removeLast();
    public void clear();
    public void replace(T newEntry);

    public void replace(T oldEntry, T newEntry);
    public int getNumElement();
    public boolean isEmpty();

}
