package data_structure.model;

public interface IHash <K, V>{

    public void put(K key, V value);
    public V remove(K key);
    public V get(K key);

}
