package data_structure.model;

public interface IStack<E> {

    public void stack(E value);
    public E unstack();
    public E top();
    public boolean isEmpty();

}
