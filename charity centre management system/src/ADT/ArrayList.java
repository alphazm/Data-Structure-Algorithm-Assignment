package ADT;

/**
 *
 * @author Alden Ling
 * @param <T>
 */
public class ArrayList<T> implements ListInterface<T> {

    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.data = (T[]) new Object[10]; // Initial capacity of 10
        this.size = 0;
    }

    public void addinArray(T item) {
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

    public void removeOut(int index) {
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

    public void expandArray() {
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

    public void clearOut() {
        size = 0; // Reset the size to 0
    }

    @Override
    public boolean add(T newEntry) {
        return false;
    }

    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    @Override
    public T remove(T anEntry) {
        return null;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        return false;
    }

    @Override
    public int getNumberOfEntries() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
}
