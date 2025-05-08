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

public class Graph implements GraphInterface<Town, Road> {

    private Set<Town> vertices = new HashSet<>();
    private Set<Road> edges = new HashSet<>();
    private Map<Town, List<Road>> adjacencyMap = new HashMap<>();
    private Map<Town, Integer> distance;
    private Map<Town, Town> previous;

    @Override
    public boolean addVertex(Town v) {
        if (v == null || vertices.contains(v)) return false;
        vertices.add(v);
        adjacencyMap.put(v, new ArrayList<>());
        return true;
    }

    @Override
    public Road addEdge(Town source, Town destination, int weight, String description) {
        if (!vertices.contains(source) || !vertices.contains(destination)) {
            throw new IllegalArgumentException("Both towns must be in the graph.");
        }
        Road road = new Road(source, destination, weight, description);
        edges.add(road);
        adjacencyMap.get(source).add(road);
        adjacencyMap.get(destination).add(road); // undirected
        return road;
    }

    @Override
    public boolean containsVertex(Town v) {
        return vertices.contains(v);
    }

    @Override
    public boolean containsEdge(Town source, Town destination) {
        return edges.stream().anyMatch(e ->
            e.contains(source) && e.contains(destination)
        );
    }

    @Override
    public Road getEdge(Town source, Town destination) {
        return edges.stream().filter(e ->
            e.contains(source) && e.contains(destination)
        ).findFirst().orElse(null);
    }

    @Override
    public Road removeEdge(Town source, Town destination, int weight, String description) {
        Road target = new Road(source, destination, weight, description);
        if (edges.remove(target)) {
            adjacencyMap.get(source).remove(target);
            adjacencyMap.get(destination).remove(target);
            return target;
        }
        return null;
    }

    @Override
    public boolean removeVertex(Town v) {
        if (!vertices.contains(v)) return false;
        vertices.remove(v);
        for (Road r : new HashSet<>(adjacencyMap.get(v))) {
            edges.remove(r);
            Town other = r.getSource().equals(v) ? r.getDestination() : r.getSource();
            adjacencyMap.get(other).remove(r);
        }
        adjacencyMap.remove(v);
        return true;
    }

    @Override
    public Set<Town> vertexSet() {
        return vertices;
    }

    @Override
    public Set<Road> edgeSet() {
        return edges;
    }

    @Override
    public Set<Road> edgesOf(Town vertex) {
        return new HashSet<>(adjacencyMap.get(vertex));
    }

    @Override
    public ArrayList<String> shortestPath(Town source, Town destination) {
        dijkstraShortestPath(source);
        ArrayList<String> path = new ArrayList<>();
        Town current = destination;
        while (previous.get(current) != null) {
            Town prev = previous.get(current);
            Road road = getEdge(current, prev);
            path.add(0, prev + " via " + road.getName() + " to " + current + " " + road.getWeight() + " mi");
            current = prev;
        }
        return path;
    }

    @Override
    public void dijkstraShortestPath(Town source) {
        distance = new HashMap<>();
        previous = new HashMap<>();
        PriorityQueue<Town> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        for (Town town : vertices) {
            distance.put(town, Integer.MAX_VALUE);
            previous.put(town, null);
        }
        distance.put(source, 0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Town current = queue.poll();
            for (Road road : adjacencyMap.get(current)) {
                Town neighbor = road.getSource().equals(current) ? road.getDestination() : road.getSource();
                int alt = distance.get(current) + road.getWeight();
                if (alt < distance.get(neighbor)) {
                    distance.put(neighbor, alt);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
