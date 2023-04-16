package test;
import data_structure.model.Queue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class QueueTest {

    //Enqueue

    @Test
    public void testEnqueueOnEmptyQueue() {
        Queue<String> queue = new Queue<>();
        String element = "Cadena";
        queue.enqueue(element);
        assertEquals(element, queue.peek());
        assertEquals(element, queue.unqueue());
    }

    @Test
    public void testEnqueueOnNonEmptyQueue() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Soy");
        queue.enqueue("Juan");
        queue.enqueue("Diaz");
        assertEquals("Soy", queue.peek());
        assertEquals("Soy", queue.unqueue());
        assertEquals("Juan", queue.peek());
        assertEquals("Juan", queue.unqueue());
        assertEquals("Diaz", queue.peek());
        assertEquals("Diaz", queue.unqueue());
    }

    @Test
    public void testEnqueueMultipleElements() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 1; i <= 100; i++) {
            queue.enqueue(i);
            assertEquals(1, queue.peek());
        }
        for (int i = 1; i <= 100; i++) {
            assertEquals(i, queue.unqueue());
        }
    }

    // Unqueue

    @Test
    public void testUnqueueHasOneElement(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        int value = queue.unqueue();
        assertEquals(10, value);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testUnqueueHasSeveralElements(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        int value = queue.unqueue();
        assertEquals(10, value);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testUnqueueEmptyQueue(){
        Queue<String> queue = new Queue<>();
        try {
        queue.unqueue();

        } catch (NoSuchElementException e) {
            System.out.println("La excepcion fue lanzada correctamente");
        }
    }

    // Peek

    @Test
    public void testPeekNotEmpty() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.peek().intValue());
    }


    @Test
    public void testPeekAfterEnqueueAndUnqueue(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.unqueue();
        queue.enqueue(3);
        assertEquals(2, (int) queue.peek());
    }

    @Test
    public void testPeekSingleElement() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertEquals(1, queue.peek().intValue());
    }

}
