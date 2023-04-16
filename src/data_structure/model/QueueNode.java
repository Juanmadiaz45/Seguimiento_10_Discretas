package data_structure.model;

public class QueueNode <E>{
    private E data;
    private QueueNode<E> next;
     
    public QueueNode(E data) {
        this.data = data;
    }


    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public QueueNode<E> getNext() {
        return this.next;
    }

    public void setNext(QueueNode<E> next) {
        this.next = next;
    }

}
