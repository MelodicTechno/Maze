import java.util.Random;

public class GraphTester {
    public static void main(String[] args) {
        Integer[] vertices = new Integer[9];
        Integer[][] edges = new Integer[9][9];
        Random integerMaker = new Random();
        for (int i = 0; i < 9; i++) {
            vertices[i] = integerMaker.nextInt(10);
        }
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                edges[row][column] = integerMaker.nextInt(50);
            }
        }
        Graph<Integer, Integer> graph = new Graph<>(vertices, edges);
        graph.addEdge(2, 1, 100);
        graph.removeEdge(3, 5);
        System.out.println("vertices: " + graph.getVertices());
        System.out.println("edges:" + graph.getEdges());

        graph.removeVertex(3);
        System.out.println("after removed, vertices: " + graph.getVertices());
        System.out.println("after removed edges:" + graph.getEdges());
    }
}
