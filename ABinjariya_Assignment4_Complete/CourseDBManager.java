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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

    private CourseDBStructure cds;

    // Default constructor
    public CourseDBManager() {
        cds = new CourseDBStructure(100); // Start with 100 course estimate
    }

    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        cds.add(element);
    }

    @Override
    public CourseDBElement get(int crn) {
        try {
            return cds.get(crn);
        } catch (Exception e) {
            return null; // Return null if course is not found
        }
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.trim().split("\\s+", 5);
            if (tokens.length < 5) continue;

            String id = tokens[0];
            int crn = Integer.parseInt(tokens[1]);
            int credits = Integer.parseInt(tokens[2]);
            String roomNum = tokens[3];
            String instructor = tokens[4];

            add(id, crn, credits, roomNum, instructor);
        }
        scanner.close();
    }

    @Override
    public ArrayList<String> showAll() {
        return cds.showAll();
    }
}
