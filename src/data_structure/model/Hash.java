package data_structure.model;
import java.util.ArrayList;

public class Hash<K, V> {
  private ArrayList<Entry<K, V>> table;
  private int capacity;
  
  public Hash(int initialCapacity) {
      this.capacity = initialCapacity;
      this.table = new ArrayList<Entry<K, V>>(this.capacity);
      for (int i = 0; i < this.capacity; i++) {
          this.table.add(null);
      }
  }
  
  public void put(K key, V value) {
    int index = this.calculateIndex(key);
    Entry<K, V> currentEntry = this.table.get(index);
      
    while (currentEntry != null) {
      if (currentEntry.getKey().equals(key)) {
      currentEntry.setValue(value);
      return;
      }
      
      currentEntry = currentEntry.getNext();
      }
      
      currentEntry = this.table.get(index);
      Entry<K, V> newEntry = new Entry<K, V>(key, value);
      newEntry.setNext(currentEntry);
      this.table.set(index, newEntry);
  }
  
  public V get(K key) {
    int index = this.calculateIndex(key);
    Entry<K, V> currentEntry = this.table.get(index);
      
    while (currentEntry != null) {
      if (currentEntry.getKey().equals(key)) {
        return currentEntry.getValue();
      }
      
      currentEntry = currentEntry.getNext();
    }
      
    return null;
  }
  
  public void remove(K key) {
    int index = this.calculateIndex(key);
    Entry<K, V> currentEntry = this.table.get(index);
    Entry<K, V> previousEntry = null;
      
    while (currentEntry != null) {
      if (currentEntry.getKey().equals(key)) {
        if (previousEntry == null) {
          this.table.set(index, currentEntry.getNext());
        } else {
          previousEntry.setNext(currentEntry.getNext());
          }
          
          return;
          }
          
          previousEntry = currentEntry;
          currentEntry = currentEntry.getNext();
      }
  }
  
  private int calculateIndex(K key) {
      int hash = key.hashCode();
      int index = Math.abs(hash) % this.capacity;
      return index;
  }
}