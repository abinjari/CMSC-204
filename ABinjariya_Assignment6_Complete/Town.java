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
import java.util.Objects;

public class Town implements Comparable<Town> {
    private String name;

    public Town(String name) {
        this.name = name;
    }

    public Town(Town other) {
        this.name = other.name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Town other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Town) {
            Town other = (Town) obj;
            return this.name.equalsIgnoreCase(other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return name;
    }
}
