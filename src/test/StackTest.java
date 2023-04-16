package test;
import data_structure.model.Stack;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackTest {

    //Stack

    @Test
    public void testStackSuccess() {
        Stack<Integer> stack = new Stack<>();
        stack.stack(1);
        stack.stack(2);
        stack.stack(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.top());
    }

    @Test
    public void testStackLimit() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 1000; i++) {
            stack.stack(i);
        }
        assertEquals(1000, stack.size());
        assertEquals(999, stack.top());
    }


    @Test
    public void testStackRepeatingElements() {
        Stack<String> newstack = new Stack<>();
        newstack.stack("element1");
        newstack.stack("element2");
        newstack.stack("element1");

        assertEquals(3, newstack.size());
        assertEquals("element1", newstack.top());
        
    }

    //Unstack

    @Test
    public void testUnstackSuccess() {
        Stack<Integer> stack = new Stack<>();
        stack.stack(1);
        stack.stack(2);
        stack.stack(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.unstack());
        assertEquals(2, stack.unstack());
        assertEquals(1, stack.top());
        assertEquals(1, stack.size());
    }

    @Test
    public void testUnstackEmptyStack() {
        Stack<String> stack = new Stack<>();
        try {
            stack.unstack();
        } catch (IllegalStateException e) {
            System.out.println("La excepcion fue lanzada correctamente");
        }
    }

    @Test
    public void testUnstackException() {
        Stack<String> stack = new Stack<>();
        assertThrows(IllegalStateException.class, stack::unstack);
    }

    //Top

    @Test
    public void testTopAfterUnstack() {
        Stack<Integer> stack = new Stack<>();
        stack.stack(1);
        stack.stack(2);
        stack.stack(3);
        stack.unstack();
        assertEquals(2, stack.top());
    }

    @Test
    public void testTopNotEmpty(){
        Stack<Integer> stack = new Stack<>();
        stack.stack(1);
        stack.stack(2);
        stack.stack(3);
        assertEquals(3, stack.top());
    }

    @Test
    public void testTestEmptyStack(){
        Stack<Character> stack = new Stack<>();
        try {
        stack.top();    
        } catch (IllegalStateException e) {
            System.out.println("La excepcion fue lanzada correctamente");
        }
    }

}