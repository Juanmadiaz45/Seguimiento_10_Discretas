package data_structure.model;

public class Stack <E> implements IStack<E>{
    private StackNode<E> top;
    private int size;
    
    public Stack() {
        top = null;
        size = 0;
    }

    @Override
    public void stack(E data) {
        StackNode<E> newNode = new StackNode<>(data, top);
        top = newNode;
        size++;
    }

    @Override
    public E unstack() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        E unstackData = top.getData();
        top = top.getNext();
        size--;
        return unstackData;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
}
