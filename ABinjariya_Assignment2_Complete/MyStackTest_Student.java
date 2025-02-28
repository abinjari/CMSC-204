/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 2/27/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyStackTest_Student {
    private MyStack<Double> studentStack;

    @BeforeEach
    void setUp() {
        studentStack = new MyStack<>(5); // Initialize stack with capacity 5
    }

    @Test
    void testIsEmpty() {
        assertTrue(studentStack.isEmpty());
        studentStack.push(1.1);
        assertFalse(studentStack.isEmpty());
    }

    @Test
    void testPush() {
        assertDoesNotThrow(() -> {
            assertTrue(studentStack.push(1.1));
            assertTrue(studentStack.push(2.2));
            assertTrue(studentStack.push(3.3));
            assertTrue(studentStack.push(4.4));
            assertTrue(studentStack.push(5.5));
        });

        assertThrows(StackOverflowException.class, () -> studentStack.push(6.6));
    }

    @Test
    void testPop() {
        studentStack.push(1.1);
        studentStack.push(2.2);
        studentStack.push(3.3);
        
        assertEquals(3.3, studentStack.pop(), 0.001);
        assertEquals(2.2, studentStack.pop(), 0.001);
        assertEquals(1.1, studentStack.pop(), 0.001);

        assertThrows(StackUnderflowException.class, () -> studentStack.pop());
    }

    @Test
    void testIsFull() {
        studentStack.push(1.1);
        studentStack.push(2.2);
        studentStack.push(3.3);
        studentStack.push(4.4);
        studentStack.push(5.5);
        
        assertTrue(studentStack.isFull());
        studentStack.pop();
        assertFalse(studentStack.isFull());
    }

    @Test
    void testSize() {
        assertEquals(0, studentStack.size());
        studentStack.push(1.1);
        studentStack.push(2.2);
        assertEquals(2, studentStack.size());
        studentStack.pop();
        assertEquals(1, studentStack.size());
    }

    @Test
    void testTop() {
        studentStack.push(1.1);
        studentStack.push(2.2);
        assertEquals(2.2, studentStack.top(), 0.001);
        studentStack.pop();
        assertEquals(1.1, studentStack.top(), 0.001);
    }

    @Test
    void testToString() {
        studentStack.push(1.1);
        studentStack.push(2.2);
        studentStack.push(3.3);
        assertEquals("1.12.23.3", studentStack.toString());
    }

    @Test
    void testToStringWithDelimiter() {
        studentStack.push(1.1);
        studentStack.push(2.2);
        studentStack.push(3.3);
        assertEquals("1.1-2.2-3.3", studentStack.toString("-"));
    }

    @Test
    void testFill() {
        ArrayList<Double> list = new ArrayList<>();
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);

        studentStack.fill(list);
        assertEquals(3, studentStack.size());
        assertEquals(3.3, studentStack.pop(), 0.001);
        assertEquals(2.2, studentStack.pop(), 0.001);
        assertEquals(1.1, studentStack.pop(), 0.001);
    }
}
