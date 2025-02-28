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

public class MyQueueTest_Student {
    private MyQueue<Double> studentQueue;
    
    @BeforeEach
    void setUp() {
        studentQueue = new MyQueue<>(5); // Initialize queue with capacity 5
    }

    @Test
    void testIsEmpty() {
        assertTrue(studentQueue.isEmpty());
        studentQueue.enqueue(1.1);
        assertFalse(studentQueue.isEmpty());
    }

    @Test
    void testEnqueue() {
        assertDoesNotThrow(() -> {
            assertTrue(studentQueue.enqueue(1.1));
            assertTrue(studentQueue.enqueue(2.2));
            assertTrue(studentQueue.enqueue(3.3));
            assertTrue(studentQueue.enqueue(4.4));
            assertTrue(studentQueue.enqueue(5.5));
        });

        assertThrows(QueueOverflowException.class, () -> studentQueue.enqueue(6.6));
    }

    @Test
    void testDequeue() {
        studentQueue.enqueue(1.1);
        studentQueue.enqueue(2.2);
        studentQueue.enqueue(3.3);
        
        assertEquals(1.1, studentQueue.dequeue(), 0.001);
        assertEquals(2.2, studentQueue.dequeue(), 0.001);
        assertEquals(3.3, studentQueue.dequeue(), 0.001);

        assertThrows(QueueUnderflowException.class, () -> studentQueue.dequeue());
    }

    @Test
    void testIsFull() {
        studentQueue.enqueue(1.1);
        studentQueue.enqueue(2.2);
        studentQueue.enqueue(3.3);
        studentQueue.enqueue(4.4);
        studentQueue.enqueue(5.5);
        
        assertTrue(studentQueue.isFull());
        studentQueue.dequeue();
        assertFalse(studentQueue.isFull());
    }

    @Test
    void testSize() {
        assertEquals(0, studentQueue.size());
        studentQueue.enqueue(1.1);
        studentQueue.enqueue(2.2);
        assertEquals(2, studentQueue.size());
        studentQueue.dequeue();
        assertEquals(1, studentQueue.size());
    }

    @Test
    void testToString() {
        studentQueue.enqueue(1.1);
        studentQueue.enqueue(2.2);
        studentQueue.enqueue(3.3);
        assertEquals("1.12.23.3", studentQueue.toString());
    }

    @Test
    void testToStringWithDelimiter() {
        studentQueue.enqueue(1.1);
        studentQueue.enqueue(2.2);
        studentQueue.enqueue(3.3);
        assertEquals("1.1-2.2-3.3", studentQueue.toString("-"));
    }

    @Test
    void testFill() {
        ArrayList<Double> list = new ArrayList<>();
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);

        studentQueue.fill(list);
        assertEquals(3, studentQueue.size());
        assertEquals(1.1, studentQueue.dequeue(), 0.001);
        assertEquals(2.2, studentQueue.dequeue(), 0.001);
        assertEquals(3.3, studentQueue.dequeue(), 0.001);
    }
}
