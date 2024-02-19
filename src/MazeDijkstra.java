import java.util.*;

public class MazeDijkstra {
    private final MazePuzzle mazePuzzle;
    private final ListGraph<Cell> graph;
    private final HashMap<Cell, Integer> distance = new HashMap<>();
    private final PriorityQueue<Cell> priorityQueue = new PriorityQueue<>();
    private Set<Cell> settled;
    private Cell[][] cells;
    private final Map<Cell, List<Cell>> adjacencyList;
    public MazeDijkstra(MazePuzzle mazePuzzle) {
        this.mazePuzzle = mazePuzzle;
        this.graph = mazePuzzle.getMazeGraph();
        this.adjacencyList = graph.getAdjacencyList();
        this.settled = new HashSet<>();
        this.cells = mazePuzzle.getCells();
    }
    // dijkstra
    public void dijkstra() {
        // initialize all the nodes
        for (int row = 0; row < MazeConstants.MAZE_SIZE; row++) {
            for (int column = 0; column < MazeConstants.MAZE_SIZE; column++) {
                distance.put(cells[row][column], Integer.MAX_VALUE);
                cells[row][column].setCost(Integer.MAX_VALUE);
            }
        }
        priorityQueue.add(cells[0][0]);
        distance.put(cells[0][0], 0);

        while (settled.size() != MazeConstants.VERTEX_NUMBER) {
            if (priorityQueue.isEmpty()) {
                return;
            }
            Cell newCell = priorityQueue.remove();
            if (settled.contains(newCell)) {
                continue;
            }
            settled.add(newCell);
        }
    }

    public MazePuzzle getMazePuzzle() {
        return mazePuzzle;
    }
}
