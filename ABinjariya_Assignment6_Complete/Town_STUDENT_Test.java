/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 05/08/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
import static org.junit.Assert.*;
import org.junit.Test;

public class Town_STUDENT_Test {

    @Test
    public void testConstructorAndGetName() {
        Town t = new Town("Springfield");
        assertEquals("Springfield", t.getName());
    }

    @Test
    public void testEquals() {
        Town t1 = new Town("Same");
        Town t2 = new Town("Same");
        Town t3 = new Town("Different");

        assertTrue(t1.equals(t2));
        assertFalse(t1.equals(t3));
    }

    @Test
    public void testCompareTo() {
        Town t1 = new Town("A");
        Town t2 = new Town("B");

        assertTrue(t1.compareTo(t2) < 0);
    }

    @Test
    public void testToStringAndHashCode() {
        Town t = new Town("TestTown");
        assertEquals("TestTown", t.toString());
        assertEquals(t.hashCode(), new Town("TestTown").hashCode());
    }

    @Test
    public void testCopyConstructor() {
        Town original = new Town("Original");
        Town copy = new Town(original);
        assertEquals(original.getName(), copy.getName());
    }
}
