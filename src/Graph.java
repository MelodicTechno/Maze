import java.util.ArrayList;
import java.util.List;

/**
 * It should be undirected
 * and described with a matrix
 * every cell should be connected I guess
 */
public class Graph<Vertex, Edge> {
    // the vertices and the matrix
    private final List<Vertex> vertices;
    private final List<List<Edge>> adjacencyMatrix;

    // constructor
    public Graph(Vertex[] vertices, Edge[][]edges) {
        this.vertices = new ArrayList<>();
        this.adjacencyMatrix = new ArrayList<>();

        // add the vertices
        for (Vertex vertex : vertices) {
            addVertex(vertex);
        }
        // add edges
        for (int row = 0; row < this.size(); row++) {
            for (int column = 0; column < this.size(); column++) {
                addEdge(row, column, edges[row][column]);
            }
        }
    }

    // get the number of the vertices
    public int size() {
        return this.vertices.size();
    }

    // add vertices
    public void addVertex(Vertex value) {
        int n = this.size();
        this.vertices.add(value);

        // add a row in the matrix
        List<Edge> newRow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newRow.add(null);
        }
        this.adjacencyMatrix.add(newRow);
        // add a new column, from left to right
        for (List<Edge> row : this.adjacencyMatrix) {
            row.add(null);
        }
    }

    // delete a vertex
    public void removeVertex(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        // remove vertex at index
        this.vertices.remove(index);
        // remove column at index
        this.adjacencyMatrix.remove(index);
        // remove column at index in the matrix
        for (List<Edge> row : adjacencyMatrix) {
            row.remove(index);
        }
    }

    // add edge between index (row, column)
    public void addEdge(int row, int column, Edge edge) {
        if (row < 0 || column < 0 || row >= this.size() || column >= this.size() || row == column) {
            throw new IndexOutOfBoundsException();
        }
        // (i, j) is the same with (j, i)
        adjacencyMatrix.get(row).set(column, edge);
        adjacencyMatrix.get(column).set(row, edge);
    }

    // remove edge at index
    public void removeEdge(int row, int column) {
        if (row < 0 || column < 0 || row >= this.size() || column >= this.size() || row == column) {
            throw new IndexOutOfBoundsException();
        }
        adjacencyMatrix.get(row).set(column, null);
        adjacencyMatrix.get(column).set(row, null);
    }
}
