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
import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface {
    private Graph graph = new Graph();

    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        return graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null;
    }

    @Override
    public String getRoad(String town1, String town2) {
        Road road = graph.getEdge(new Town(town1), new Town(town2));
        return road != null ? road.getName() : null;
    }

    @Override
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    @Override
    public Town getTown(String name) {
        return graph.vertexSet().stream()
                .filter(t -> t.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public boolean containsTown(String v) {
        return graph.containsVertex(new Town(v));
    }

    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> list = new ArrayList<>();
        for (Road road : graph.edgeSet())
            list.add(road.getName());
        Collections.sort(list);
        return list;
    }

    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        Road removed = graph.removeEdge(new Town(town1), new Town(town2), -1, road);
        return removed != null;
    }

    @Override
    public boolean deleteTown(String v) {
        return graph.removeVertex(new Town(v));
    }

    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> list = new ArrayList<>();
        for (Town town : graph.vertexSet())
            list.add(town.getName());
        Collections.sort(list);
        return list;
    }

    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }
}
