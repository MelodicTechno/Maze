public class ListGraphTester {
    public static void main(String[] args) {
        ListGraph<Integer, Integer> listGraph = new ListGraph<>();
        listGraph.addVertex(1);
        listGraph.addVertex(2);
        listGraph.addVertex(3);
        listGraph.addVertex(4);
        listGraph.addEdge(1, 3, 1);
        listGraph.addEdge(2, 4, 1);
        listGraph.addEdge(1, 4, 1);
        listGraph.print();
        System.out.println(listGraph.getNumberOfVertices());
        listGraph.removeEdge(1, 4);
        listGraph.removeVertex(1);
        listGraph.print();
        System.out.println(listGraph.getNumberOfVertices());
    }
}
