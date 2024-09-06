
package ADT;

/**
 *

 * @author Heng Wei Long
 */
public interface ListInterface<T> {
    public boolean add(T newEntry);
    public T getEntry(int givenPosition);
    public T remove(T anEntry);
    public void clear();
    public boolean replace(int givenPosition, T newEntry);
    public int getNumberOfEntries();
    public boolean isEmpty();

    public boolean add(int newPosition, T newEntry);
    public boolean isFull();
    public boolean contains(T anEntry);
    
    public void addinArray(T item);
    public T get(int index);
    public void removeOut (int index);
    public int size();
    public void expandArray();
    public void update(int index,T newItem);
}
