package data_structure.model;

public class StackNode<E> {
    private E data;
    private StackNode<E> next;
        
        public StackNode(E data, StackNode<E> next) {
            this.data = data;
            this.next = next;
        }
        
        public E getData() {
            return data;
        }
        
        public StackNode<E> getNext() {
            return next;
        }
        
        public void setNext(StackNode<E> next) {
            this.next = next;
        }
}
