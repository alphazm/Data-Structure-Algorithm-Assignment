package ADT;
/**
 *
 * @author Chong Zhi Ming
 */
public interface StackInterface<T> {
    public void push(T newEntry);
    public T pop();
    public T peek();
    public boolean isEmpty();
    
}
