
package ADT;

import java.util.Iterator;

public interface LinkedQueueInterface<T> {
    public Iterator<T> getIterator();
    public boolean isEmpty();
    public int getSize();
    public void enqueue(T newData);
    public T dequeue();
    public T peek();
    public void clear();
    public String toString();
}
