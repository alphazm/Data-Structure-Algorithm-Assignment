
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
    public boolean replace(T givenPos, T newEntry);
    public int getNumElement();
    public boolean isEmpty();

    public boolean add(int newPosition, T newEntry);
    public int getNumberOfEntries();
    public boolean isFull();
    public boolean contains(T anEntry);
}
