package test;
import data_structure.model.Hash;
import data_structure.model.IHash;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashTest {
    private Hash<String, Integer> table;

    // Put
    
    @BeforeEach
    public void setUp() {
        table = new Hash<String, Integer>(10);
    }
    
    @Test
    public void testPutNewEntry() {
        table.put("Dany", 40);
        assertEquals(40, (int)table.get("Dany"));
    }
    
    @Test
    public void testPutExistingEntry() {
        table.put("Dany", 25);
        table.put("Dany", 30);
        assertEquals(30, (int)table.get("Dany"));
    }
    
    @Test
    public void testPutMultipleEntries() {
        table.put("Dany", 35);
        table.put("Bob", 30);
        table.put("Charlie", 35);
        assertEquals(35, (int)table.get("Dany"));
        assertEquals(30, (int)table.get("Bob"));
        assertEquals(35, (int)table.get("Charlie"));
    }

    // Remove

    @Test
    public void testRemoveFromEmptyTable(){
        setUp();
        table.remove("First");
        assertEquals(null, table.get("First"));
    }

    @Test
    public void testRemoveKeyFirstPosition(){
        setUp();
        table.put("First", 1);
        table.put("Second", 2);
        table.put("Third", 3);

        table.remove("Second");

        assertEquals(null, table.get("Second"));
        assertEquals(Integer.valueOf(1), table.get("First"));
        assertEquals(Integer.valueOf(3), table.get("Third"));
    }

    @Test
    public void testRemoveKeyLastPosition(){
        setUp();
        table.put("First", 1);
        table.put("Second", 2);
        table.put("Third", 3);

        table.remove("Third");

        assertEquals(null, table.get("Third"));
        assertEquals(Integer.valueOf(1), table.get("First"));
        assertEquals(Integer.valueOf(2), table.get("Second"));
    }

    // Get

    @Test
    public void testGetValueExisting(){
        setUp();
        table.put("k1", 50);
        table.put("k2", 60);
        table.put("k3", 70);

        assertEquals(Integer.valueOf(60), table.get("k2"));

    }

    @Test
    public void testGetAfterRemove(){
        setUp();
        table.put("k1", 50);
        table.put("k2", 60);
        table.put("k3", 70);
        table.remove("k2");

        assertEquals(Integer.valueOf(50), table.get("k1"));
        assertNull(table.get("k2"));
        assertEquals(Integer.valueOf(70), table.get("k3"));
    }

    @Test
    public void testGetNonExistingValue(){
        setUp();
        table.put("k1", 50);
        table.put("k2", 60);
        table.put("k3", 70);

        assertNull(table.get("k4"));
    }
}
