/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 03/31/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {

    private CourseDBManager manager;

    @Before
    public void setUp() throws Exception {
        manager = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    @Test
    public void testAddAndGetCourse() {
        manager.add("CMSC204", 12345, 4, "SC450", "Dr. Who");
        CourseDBElement element = manager.get(12345);
        assertNotNull(element);
        assertEquals("CMSC204", element.getID());
        assertEquals(12345, element.getCRN());
        assertEquals(4, element.getCredits());
        assertEquals("SC450", element.getRoomNum());
        assertEquals("Dr. Who", element.getInstructorName());
    }

    @Test
    public void testShowAll() {
        manager.add("CMSC140", 11111, 3, "HT300", "Professor X");
        manager.add("CMSC150", 22222, 4, "SW210", "Jean Grey");

        ArrayList<String> courses = manager.showAll();

        assertTrue(courses.size() >= 2); // Might contain more from other tests
        boolean foundCMSC140 = false;
        boolean foundCMSC150 = false;

        for (String s : courses) {
            if (s.contains("CMSC140") && s.contains("11111")) foundCMSC140 = true;
            if (s.contains("CMSC150") && s.contains("22222")) foundCMSC150 = true;
        }

        assertTrue(foundCMSC140);
        assertTrue(foundCMSC150);
    }

    @Test
    public void testReadFile() {
        try {
            File testFile = new File("test_input.txt");
            PrintWriter writer = new PrintWriter(testFile);
            writer.println("CMSC122 45678 3 SC200 Charles Xavier");
            writer.println("CMSC125 56789 4 HT301 Erik Lehnsherr");
            writer.close();

            manager.readFile(testFile);

            CourseDBElement c1 = manager.get(45678);
            CourseDBElement c2 = manager.get(56789);

            assertEquals("CMSC122", c1.getID());
            assertEquals("Charles Xavier", c1.getInstructorName());
            assertEquals("HT301", c2.getRoomNum());
        } catch (FileNotFoundException e) {
            fail("File should have been found.");
        }
    }
}
