package data_structure.model;

public class Entry<K, V> {
    private K key;
    private V value;
    private Entry<K, V> next;
    
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    
    public K getKey() {
        return this.key;
    }
    
    public V getValue() {
        return this.value;
    }
    
    public void setValue(V value) {
        this.value = value;
    }
    
    public Entry<K, V> getNext() {
        return this.next;
    }
    
    public void setNext(Entry<K, V> next) {
        this.next = next;
    }
}