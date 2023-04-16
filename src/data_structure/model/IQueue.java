package data_structure.model;

public interface IQueue <E>{
    
    public void enqueue(E value);
    public E unqueue();
    public E peek();
    public boolean isEmpty();

}
