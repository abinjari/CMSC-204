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
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for BasicDoubleLinkedList.
 * Tests the core functionalities including adding, retrieving, removing, iteration, and list conversion.
 * @author [Your Name]
 */
class BasicDoubleLinkedList_Student_Test {

    private BasicDoubleLinkedList<Student> studentList;
    private Student alice, bob, charlie, diana;

    @BeforeEach
    void setup() throws Exception {
        studentList = new BasicDoubleLinkedList<>();
        alice = new Student("Alice", 22, 1001);
        bob = new Student("Bob", 30, 1002);
        charlie = new Student("Charlie", 27, 1000);
        diana = new Student("Diana", 19, 1005);

        studentList.addToEnd(alice);
        studentList.addToFront(bob);
        studentList.addToEnd(charlie);
        studentList.addToEnd(diana);
    }

    @AfterEach
    void tearDown() throws Exception {
        alice = bob = charlie = diana = null;
        studentList = null;
    }

    @Test
    void testInsertAtFrontAndGetFirst() {
        int initialSize = studentList.getSize();
        Student edward = new Student("Edward", 20, 1006);
        studentList.addToFront(edward);
        assertEquals(edward, studentList.getFirst());
        assertEquals(initialSize + 1, studentList.getSize());
    }

    @Test
    void testInsertAtEndAndGetLast() {
        int initialSize = studentList.getSize();
        Student edward = new Student("Edward", 20, 1006);
        studentList.addToEnd(edward);
        assertEquals(edward, studentList.getLast());
        assertEquals(initialSize + 1, studentList.getSize());
    }

    @Test
    void testRetrieveFirstAndLast() {
        int initialSize = studentList.getSize();
        Student firstRemoved = studentList.retrieveFirstElement();
        assertEquals(bob, firstRemoved);
        assertEquals(initialSize - 1, studentList.getSize());

        Student lastRemoved = studentList.retrieveLastElement();
        assertEquals(diana, lastRemoved);
        assertEquals(initialSize - 2, studentList.getSize());
    }

    @Test
    void testRemoveElement() {
        int initialSize = studentList.getSize();
        StudentComparator comparator = new StudentComparator();

        Student edward = new Student("Edward", 20, 1006);
        assertNull(studentList.remove(edward, comparator));
        assertEquals(initialSize, studentList.getSize());

        assertEquals(alice, studentList.remove(alice, comparator).data);
        assertEquals(initialSize - 1, studentList.getSize());
    }

    @Test
    void testConvertToArrayList() {
        ArrayList<Student> array = studentList.toArrayList();
        assertEquals(bob, array.get(0));
        assertEquals(alice, array.get(1));
        assertEquals(charlie, array.get(2));
        assertEquals(diana, array.get(3));
    }

    @Test
    void testListIterator() {
        StringBuilder output = new StringBuilder();
        for (Student s : studentList) {
            output.append(s.getName());
        }
        assertEquals("BobAliceCharlieDiana", output.toString());
    }

    /**
     * Comparator for Student objects based on Student ID.
     */
    private class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getStudentID(), s2.getStudentID());
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
