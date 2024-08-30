package ADT;

/**
 *
 * @author Alden Ling 
 */
public interface ListInterface<T>{

    public void add(T item);

    public T get(int index);

    public void remove(int index);

    public int size();

    public void update(int index, T newItem) ;
}
