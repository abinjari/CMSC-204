/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 03/14/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for SortedDoubleLinkedList.
 * Tests functionality including adding, removing, and sorting elements using different comparators.
 * @author [Your Name]
 */
class SortedDoubleLinkedList_Student_Test {

    private StudentIDComparator idSorter;
    private StudentAgeComparator ageSorter;
    private StudentNameComparator nameSorter;

    private SortedDoubleLinkedList<Student> sortedByID;
    private SortedDoubleLinkedList<Student> sortedByAge;
    private SortedDoubleLinkedList<Student> sortedByName;

    private Student adam, brenda, carlos, deborah;

    @BeforeEach
    void setup() throws Exception {
        idSorter = new StudentIDComparator();
        ageSorter = new StudentAgeComparator();
        nameSorter = new StudentNameComparator();

        sortedByID = new SortedDoubleLinkedList<>(idSorter);
        sortedByAge = new SortedDoubleLinkedList<>(ageSorter);
        sortedByName = new SortedDoubleLinkedList<>(nameSorter);

        adam = new Student("Adam", 20, 2001);
        brenda = new Student("Brenda", 35, 2002);
        carlos = new Student("Carlos", 29, 1999);
        deborah = new Student("Deborah", 18, 2010);

        sortedByID.add(adam);
        sortedByID.add(brenda);
        sortedByID.add(carlos);
        sortedByID.add(deborah);

        sortedByAge.add(adam);
        sortedByAge.add(brenda);
        sortedByAge.add(carlos);
        sortedByAge.add(deborah);

        sortedByName.add(adam);
        sortedByName.add(brenda);
        sortedByName.add(carlos);
        sortedByName.add(deborah);
    }

    @AfterEach
    void tearDown() throws Exception {
        adam = brenda = carlos = deborah = null;
        idSorter = null;
        ageSorter = null;
        nameSorter = null;
        sortedByID = null;
        sortedByAge = null;
        sortedByName = null;
    }

    @Test
    void testAddElement() {
        Student ethan = new Student("Ethan", 25, 2005);

        int initialSize = sortedByID.getSize();
        sortedByID.add(ethan);
        assertEquals(initialSize + 1, sortedByID.getSize());
        assertTrue(sortedByID.toArrayList().contains(ethan));

        initialSize = sortedByAge.getSize();
        sortedByAge.add(ethan);
        assertEquals(initialSize + 1, sortedByAge.getSize());
        assertTrue(sortedByAge.toArrayList().contains(ethan));

        initialSize = sortedByName.getSize();
        sortedByName.add(ethan);
        assertEquals(initialSize + 1, sortedByName.getSize());

        // Check Ethan is in the list
        ArrayList<Student> nameSortedList = sortedByName.toArrayList();
        assertTrue(nameSortedList.contains(ethan));

        // Verify correct sorting order
        int ethanIndex = nameSortedList.indexOf(ethan);
        for (int i = 0; i < ethanIndex; i++) {
            assertTrue(nameSortedList.get(i).getName().compareTo(ethan.getName()) < 0);
        }
        for (int i = ethanIndex + 1; i < nameSortedList.size(); i++) {
            assertTrue(nameSortedList.get(i).getName().compareTo(ethan.getName()) > 0);
        }
    }

    @Test
    void testRemoveElement() {
        int initialSize = sortedByID.getSize();

        Student frank = new Student("Frank", 21, 2015);
        assertNull(sortedByID.remove(frank, idSorter));
        assertEquals(initialSize, sortedByID.getSize());

        assertEquals(adam, sortedByID.remove(adam, idSorter).data);
        assertEquals(initialSize - 1, sortedByID.getSize());
    }

    /**
     * Comparator for sorting students by ID in ascending order.
     */
    private class StudentIDComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getStudentID(), s2.getStudentID());
        }
    }

    /**
     * Comparator for sorting students by age in ascending order.
     */
    private class StudentAgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getAge(), s2.getAge());
        }
    }

    /**
     * Comparator for sorting students alphabetically by name.
     */
    private class StudentNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }

    /**
     * Inner class representing a Student entity with name, age, and student ID.
     */
    private final class Student {
        private final String name;
        private final int age;
        private final int studentID;

        public Student(String name, int age, int studentID) {
            this.name = name;
            this.age = age;
            this.studentID = studentID;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getStudentID() {
            return studentID;
        }

        @Override
        public String toString() {
            return "[ID: " + studentID + "] " + name + " | Age: " + age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Student) {
                Student other = (Student) obj;
                return this.name.equals(other.name) && this.age == other.age && this.studentID == other.studentID;
            }
            return false;
        }
    }
}

