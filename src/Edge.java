public class Edge<Vertex, Weight extends Comparable<Weight>> {
    private final Vertex neighbor;
    private final Weight weight;
    // Constructor
    public Edge(Vertex vertex, Weight weight) {
        this.neighbor = vertex;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "(" + neighbor + "," + weight + ")";
    }

    public Vertex getNeighbor() {
        return this.neighbor;
    }

    public Weight getWeight() {
        return this.weight;
    }
}
