import java.util.*;


public class ListGraph<Vertex, Weight extends Comparable<Weight>> {
    // The adjacency list
    private final Map<Vertex, List<Edge<Vertex, Weight>>> adjacencyList;
    // constructor
    public ListGraph() {
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
            return;
        }

        List<Edge<Vertex, Weight>> neighbors = adjacencyList.get(vertex);
        for (Edge<Vertex, Weight> edge : neighbors) {
            Edge<Vertex, Weight> findedEdge = findEdgeByNode(edge.getNeighbor(), vertex);
            adjacencyList.get(edge.getNeighbor()).remove(findedEdge);
        }
        // delete the vertex
        adjacencyList.remove(vertex);
    }

    // get the number of the vertices
    public int getNumberOfVertices() {
        return adjacencyList.size();
    }

    // add edges
    public void addEdge(Vertex vertex1, Vertex vertex2, Weight weight) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2) || vertex1.equals(vertex2)) {
            return;
        }
        // add the edge between v1 and v2
        adjacencyList.get(vertex1).add(new Edge<>(vertex2, weight));
        adjacencyList.get(vertex2).add(new Edge<>(vertex1, weight));
    }

    // remove edges
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2) || vertex1.equals(vertex2)) {
            return;
        }
        // remove edge between v1 and v2
        List<Edge<Vertex, Weight>> neighbors1 = adjacencyList.get(vertex1);
        List<Edge<Vertex, Weight>> neighbors2 = adjacencyList.get(vertex2);
        if (neighbors1 == null || neighbors2 == null) {
            return;
        }
        Edge<Vertex, Weight> edge1 = findEdgeByNode(vertex1, vertex2);
        if (edge1 == null) {
            return;
        }
        neighbors1.remove(edge1);
        Edge<Vertex, Weight> edge2 = findEdgeByNode(vertex2, vertex1);
        if (edge2 == null) {
            return;
        }
        neighbors2.remove(edge2);
    }

    private Edge<Vertex, Weight> findEdgeByNode(Vertex vertex1, Vertex vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            return null;
        }
        List<Edge<Vertex, Weight>> theEdges = adjacencyList.get(vertex1);
        for (Edge<Vertex, Weight> edge : theEdges) {
            if (edge.getNeighbor().equals(vertex2)) {
                return edge;
            }
        }
        return null;
    }

    // print the adjacency list
    public void print() {
        System.out.println("the adjacency list:");
        for (Map.Entry<Vertex, List<Edge<Vertex, Weight>>> pair : adjacencyList.entrySet()) {
            List<Edge<Vertex, Weight>> tmp = new ArrayList<>(pair.getValue());
            System.out.println(pair.getKey() + " : " + tmp + " , ");
        }
    }

    public Map<Vertex, List<Edge<Vertex, Weight>>> getAdjacencyList() {
        return this.adjacencyList;
    }
}
