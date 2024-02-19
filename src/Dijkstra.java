import java.util.*;

public class Dijkstra<Vertex> {
    private final Set<Node<Vertex>> nodes = new HashSet<>();
    private static class Node<Vertex> {
        private final List<Node<Vertex>> shortestPath = new LinkedList<>();
        private Integer distance = Integer.MAX_VALUE;
        Map<Node<Vertex>, Node<Vertex>> adjacencyList = new HashMap<>();
        
    }
}
