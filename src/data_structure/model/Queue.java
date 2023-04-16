package data_structure.model;
import java.util.NoSuchElementException;

public class Queue<E> implements IQueue<E> {
    private QueueNode<E> head;
    private QueueNode<E> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void enqueue(E value) {
        QueueNode<E> newNode = new QueueNode<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public E unqueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        E value = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return head.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }
}

