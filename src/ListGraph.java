import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListGraph<Vertex> {
    // The adjacency list
    private final Map<Vertex, List<Vertex>> adjacencyList;
    // constructor
    public ListGraph(Vertex[][] edges) {
        this.adjacencyList = new HashMap<>();
    }

    // Add vertices
    public void addVertex(Vertex vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return;
        }
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Remove a vertex
    public void removeVertex(Vertex vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException();
        }
        // delete v's edges
        adjacencyList.remove(vertex);
        for (List<Vertex> list : adjacencyList.values()) {
            list.remove(vertex);
        }
    }

    // get the number of the vertices
    public int getNumberOfVertices() {
        return adjacencyList.size();
    }

    // add edges
    public void addEdge(Vertex vertex1, Vertex vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2) || vertex1.equals(vertex2)) {
            throw new IllegalArgumentException();
        }
        // add the edge between v1 and v2
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    // remove edges
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2) || vertex1.equals(vertex2)) {
            throw new IllegalArgumentException();
        }
        // remove edge between v1 and v2
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
    }
}
