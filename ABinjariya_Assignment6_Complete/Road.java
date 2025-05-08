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
public class Road implements Comparable<Road> {
    private Town source;
    private Town destination;
    private int weight;
    private String name;

    public Road(Town source, Town destination, int weight, String name) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.name = name;
    }

    public Road(Town source, Town destination, String name) {
        this(source, destination, 1, name);
    }

    public boolean contains(Town town) {
        return town.equals(source) || town.equals(destination);
    }

    public Town getSource() {
        return source;
    }

    public Town getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Road other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Road) {
            Road other = (Road) obj;
            return (source.equals(other.source) && destination.equals(other.destination) ||
                    source.equals(other.destination) && destination.equals(other.source)) &&
                    this.name.equalsIgnoreCase(other.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name + ": " + source + " <--> " + destination + " (" + weight + " mi)";
    }

    @Override
    public int hashCode() {
        return source.hashCode() + destination.hashCode() + name.toLowerCase().hashCode();
    }
}
