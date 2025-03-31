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
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

    private LinkedList<CourseDBElement>[] hashTable;
    private int tableSize;

    // Constructor with estimated number of courses
    @SuppressWarnings("unchecked")
    public CourseDBStructure(int n) {
        tableSize = getNext4kPlus3Prime((int)(n / 1.5));
        hashTable = new LinkedList[tableSize];
    }

    // Constructor for testing
    @SuppressWarnings("unchecked")
    public CourseDBStructure(String testing, int size) {
        tableSize = size;
        hashTable = new LinkedList[tableSize];
    }

    @Override
    public void add(CourseDBElement element) {
        int index = getIndex(element.getCRN());
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }

        // Check for duplicate CRN and update if found
        for (int i = 0; i < hashTable[index].size(); i++) {
            if (hashTable[index].get(i).equals(element)) {
                hashTable[index].set(i, element); // update
                return;
            }
        }

        hashTable[index].add(element);
    }

    @Override
    public CourseDBElement get(int crn) throws IOException {
        int index = getIndex(crn);
        if (hashTable[index] != null) {
            for (CourseDBElement element : hashTable[index]) {
                if (element.getCRN() == crn) {
                    return element;
                }
            }
        }
        throw new IOException("Course with CRN " + crn + " not found.");
    }

    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> result = new ArrayList<>();
        for (LinkedList<CourseDBElement> bucket : hashTable) {
            if (bucket != null) {
                for (CourseDBElement element : bucket) {
                    result.add(element.toString());
                }
            }
        }
        return result;
    }

    @Override
    public int getTableSize() {
        return tableSize;
    }

    // Hash index calculation based on CRN's string hash code
    private int getIndex(int crn) {
        int hash = Integer.toString(crn).hashCode();
        return Math.abs(hash) % tableSize;
    }

    // Helper method to find next 4k+3 prime
    private int getNext4kPlus3Prime(int min) {
        int num = min + 1;
        while (true) {
            if (isPrime(num) && (num - 3) % 4 == 0) {
                return num;
            }
            num++;
        }
    }

    // Primality check
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
