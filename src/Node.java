import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node<Vertex> {
    private List<Node<Vertex>> shortestPath = new LinkedList<>();
    private Integer distance;

    private final Vertex vertex;
    private final Map<Node<Vertex>, Integer> adjacencyList = new HashMap<>();
    // constructor
    public Node(Vertex vertex) {
        this.distance = Integer.MAX_VALUE;
        this.vertex = vertex;
    }

    // Add destination from a node to another one
    public void addDestination(Node<Vertex> destination, int distance) {
        this.adjacencyList.put(destination, distance);
    }

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Map<Node<Vertex>, Integer> getAdjacencyList() {
        return this.adjacencyList;
    }

    public List<Node<Vertex>> getShortestPath() {
        return this.shortestPath;
    }

    public void setShortestPath(List<Node<Vertex>> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Vertex getVertex() {
        return this.vertex;
    }
}
