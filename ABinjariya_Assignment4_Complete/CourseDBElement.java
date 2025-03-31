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
public class CourseDBElement implements Comparable<CourseDBElement> {
    private String courseID;
    private int crn;
    private int credits;
    private String roomNum;
    private String instructorName;

    // Constructors
    public CourseDBElement() {}

    public CourseDBElement(String courseID, int crn, int credits, String roomNum, String instructorName) {
        this.courseID = courseID;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructorName = instructorName;
    }

    // Getters
    public String getID() {
        return courseID;
    }

    public int getCRN() {
        return crn;
    }

    public int getCredits() {
        return credits;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getInstructorName() {
        return instructorName;
    }

    // Setters
    public void setID(String courseID) {
        this.courseID = courseID;
    }

    public void setCRN(int crn) {
        this.crn = crn;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    // CompareTo based on CRN
    @Override
    public int compareTo(CourseDBElement other) {
        return Integer.compare(this.crn, other.crn);
    }

    // hashCode based on CRN string
    @Override
    public int hashCode() {
        return Integer.toString(crn).hashCode();
    }

    // equals compares CRNs
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CourseDBElement) {
            return this.crn == ((CourseDBElement) obj).crn;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nCourse:" + courseID + 
               " CRN:" + crn + 
               " Credits:" + credits + 
               " Instructor:" + instructorName + 
               " Room:" + roomNum;
    }
}
