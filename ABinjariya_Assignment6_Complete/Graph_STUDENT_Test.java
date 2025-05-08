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
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class Graph_STUDENT_Test {
    private Graph graph;
    private Town t1, t2, t3, t4;

    @Before
    public void setUp() {
        graph = new Graph();
        t1 = new Town("X");
        t2 = new Town("Y");
        t3 = new Town("Z");
        t4 = new Town("W");

        graph.addVertex(t1);
        graph.addVertex(t2);
        graph.addVertex(t3);
        graph.addVertex(t4);

        graph.addEdge(t1, t2, 2, "R1");
        graph.addEdge(t2, t3, 3, "R2");
        graph.addEdge(t3, t4, 4, "R3");
    }

    @Test
    public void testContainsVertex() {
        assertTrue(graph.containsVertex(t1));
        assertFalse(graph.containsVertex(new Town("Unknown")));
    }

    @Test
    public void testContainsEdge() {
        assertTrue(graph.containsEdge(t1, t2));
        assertFalse(graph.containsEdge(t1, t4));
    }

    @Test
    public void testShortestPath() {
        ArrayList<String> path = graph.shortestPath(t1, t4);
        assertEquals(3, path.size());
        assertTrue(path.get(0).contains("X via R1 to Y 2 mi"));
        assertTrue(path.get(2).contains("Z via R3 to W 4 mi"));
    }

    @Test
    public void testRemoveVertexAndEdge() {
        assertTrue(graph.removeVertex(t3));
        assertFalse(graph.containsVertex(t3));
        assertFalse(graph.containsEdge(t2, t3));
    }

    @Test
    public void testEdgesOf() {
        Set<Road> edges = graph.edgesOf(t2);
        assertEquals(2, edges.size());
    }

    @Test
    public void testEdgeSetAndVertexSet() {
        assertEquals(3, graph.edgeSet().size());
        assertEquals(4, graph.vertexSet().size());
    }
}
