import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
    }

    @Test
    public void testGetEdges() {
        List<Edge> edges = new ArrayList<>();
        Node node1 = new Node();
        Node node2 = new Node();
        Edge edge1 = new Edge(node1, node2, "label1");
        edges.add(edge1);

        graph.getEdges().addAll(edges);
        assertEquals(edges, graph.getEdges());
    }

    @Test
    public void testGetStart() {
        Node startNode = new Node();
        graph.setStart(startNode);
        assertEquals(startNode, graph.getStart());
    }

    @Test
    public void testSetStart() {
        Node startNode = new Node();
        graph.setStart(startNode);
        assertEquals(startNode, graph.getStart());
    }

    @Test
    public void testGetEnd() {
        Node endNode = new Node();
        graph.setEnd(endNode);
        assertEquals(endNode, graph.getEnd());
    }

    @Test
    public void testSetEnd() {
        Node endNode = new Node();
        graph.setEnd(endNode);
        assertEquals(endNode, graph.getEnd());
    }

    @Test
    public void testStarWithGraph() {
        Node startNode = new Node();
        Node endNode = new Node();
        Edge edge = new Edge(startNode, endNode, "a");
        graph.getEdges().add(edge);
        graph.setStart(startNode);
        graph.setEnd(endNode);

        Graph graph2 = new Graph();
        graph.Star(graph2);

        List<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(startNode, endNode, "epsilon"));
        expectedEdges.add(new Edge(startNode, startNode, "epsilon"));
        expectedEdges.add(new Edge(endNode, endNode, "epsilon"));
        expectedEdges.add(new Edge(endNode, startNode, "epsilon"));
        expectedEdges.add(new Edge(startNode, endNode, "a"));

        assertEquals(expectedEdges, graph.getEdges());
    }

    @Test
    public void testStarWithCharacter() {
        Node startNode = new Node();
        Node endNode = new Node();
        Edge edge = new Edge(startNode, endNode, "a");
        graph.getEdges().add(edge);
        graph.setStart(startNode);
        graph.setEnd(endNode);

        char character = 'a';
        graph.Star(character);

        List<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(startNode, endNode, "a"));
        expectedEdges.add(new Edge(startNode, startNode, "epsilon"));
        expectedEdges.add(new Edge(endNode, endNode, "epsilon"));
        expectedEdges.add(new Edge(startNode, endNode, "epsilon"));

        assertEquals(expectedEdges, graph.getEdges());
    }


}
