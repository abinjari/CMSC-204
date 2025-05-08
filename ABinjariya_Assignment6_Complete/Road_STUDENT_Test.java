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

public class Road_STUDENT_Test {

    @Test
    public void testConstructorAndGetters() {
        Town a = new Town("A");
        Town b = new Town("B");
        Road r = new Road(a, b, 5, "Main");

        assertEquals("Main", r.getName());
        assertEquals(5, r.getWeight());
        assertTrue(r.contains(a));
        assertTrue(r.contains(b));
    }

    @Test
    public void testEqualsAndHashCode() {
        Road r1 = new Road(new Town("X"), new Town("Y"), 3, "R1");
        Road r2 = new Road(new Town("Y"), new Town("X"), 3, "R1");

        assertEquals(r1, r2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    public void testCompareTo() {
        Road r1 = new Road(new Town("A"), new Town("B"), 3, "Alpha");
        Road r2 = new Road(new Town("C"), new Town("D"), 4, "Beta");

        assertTrue(r1.compareTo(r2) < 0);
    }

    @Test
    public void testToString() {
        Town t1 = new Town("Town1");
        Town t2 = new Town("Town2");
        Road road = new Road(t1, t2, 7, "RoadName");
        assertTrue(road.toString().contains("RoadName"));
    }
}
