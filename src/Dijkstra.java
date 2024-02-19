import java.util.*;

public class Dijkstra<Vertex> {
    // private final Set<Node<Vertex>> nodes = new HashSet<>();
    public ListGraph<Node<Vertex>> calculateShortestPathFromSource(ListGraph<Node<Vertex>> graph, Node<Vertex> source) {
        // The beginning of the graph
        source.setDistance(0);
        // Set<Node<Vertex>> settledNodes = new HashSet<>();
        Set<Node<Vertex>> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);
        while (!unsettledNodes.isEmpty()) {
            Node<Vertex> currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node<Vertex>, Integer> adjacencyPair : currentNode.getAdjacencyList().entrySet()) {
                Node<Vertex> adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                unsettledNodes.add(adjacentNode);
            }
            // settledNodes.add(currentNode);
        }
        return graph;
    }
    // Compare the nodes between the neighbors
    private Node<Vertex> getLowestDistanceNode(Set<Node<Vertex>> unsettledNodes) {
        Node<Vertex> lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node<Vertex> node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    // calculate the minimum distance
    private void calculateMinimumDistance(Node<Vertex> evaluationNode, Integer edgeWeight, Node<Vertex> sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeight < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            LinkedList<Node<Vertex>> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
