import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BSTGraph<Vertex extends Comparable<Vertex>> {
    private final MyBST<Vertex, List<Vertex>> adjacencyList;
    public BSTGraph() {
        this.adjacencyList = new MyBST<>();
    }
    public void addVertex(Vertex vertex) {
        if (adjacencyList.search(vertex) != null) {
            return;
        }
        adjacencyList.insert(vertex, new ArrayList<>());
    }

    public void removeVertex(Vertex vertex) {

    }
}
