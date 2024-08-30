package ADT;
/**
 *
 * @author Alden Ling 
 * @param <T>
 */
public class CustomArrayList<T> {

    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        this.data = (T[]) new Object[10]; // Initial capacity of 10
        this.size = 0;
    }

    public void add(T item) {
        if (size == data.length) {
            // Resize the array when it's full
            expandArray();
        }
        data[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    private void expandArray() {
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void update(int index, T newItem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = newItem;
    }
}
