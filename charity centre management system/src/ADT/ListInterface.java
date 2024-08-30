/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADT;

/**
 *
 * @author User
 */
public interface ListInterface<T>{

    public void add(T item);

    public T get(int index);

    public void remove(int index);

    public int size();

    public void update(int index, T newItem) ;
}
