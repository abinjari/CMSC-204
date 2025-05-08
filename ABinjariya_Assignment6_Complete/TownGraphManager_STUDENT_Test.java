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
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class TownGraphManager_STUDENT_Test {
    private TownGraphManager manager;

    @Before
    public void setUp() {
        manager = new TownGraphManager();
        manager.addTown("A");
        manager.addTown("B");
        manager.addTown("C");
        manager.addRoad("A", "B", 3, "Road1");
        manager.addRoad("B", "C", 4, "Road2");
    }

    @Test
    public void testAddTownAndRoad() {
        assertTrue(manager.containsTown("A"));
        assertTrue(manager.containsRoadConnection("A", "B"));
    }

    @Test
    public void testGetRoad() {
        assertEquals("Road1", manager.getRoad("A", "B"));
    }

    @Test
    public void testAllRoadsSorted() {
        ArrayList<String> roads = manager.allRoads();
        assertEquals(2, roads.size());
        assertEquals("Road1", roads.get(0));
        assertEquals("Road2", roads.get(1));
    }

    @Test
    public void testShortestPath() {
        ArrayList<String> path = manager.getPath("A", "C");
        assertEquals(2, path.size());
        assertTrue(path.get(0).contains("A via Road1 to B 3 mi"));
        assertTrue(path.get(1).contains("B via Road2 to C 4 mi"));
    }

    @Test
    public void testDeleteTown() {
        assertTrue(manager.deleteTown("C"));
        assertFalse(manager.containsTown("C"));
    }

    @Test
    public void testDeleteRoad() {
        assertTrue(manager.deleteRoadConnection("A", "B", "Road1"));
        assertFalse(manager.containsRoadConnection("A", "B"));
    }
}
