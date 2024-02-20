import java.util.*;

public class MazeDijkstra {
    private final HashMap<Cell, Integer> distance = new HashMap<>();
    private final PriorityQueue<Cell> priorityQueue = new PriorityQueue<>();
    private final Set<Cell> settled;
    private final Cell[][] cells;
    private final Map<Cell, List<Cell>> adjacencyList;
    public MazeDijkstra(MazePuzzle mazePuzzle) {
        ListGraph<Cell> graph = mazePuzzle.getMazeGraph();
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

            eNeighbors(newCell);
        }
    }

    private void eNeighbors(Cell newCell) {
        int edgeDistance;
        int newDistance;
        // all the neighbors of Cell newCell
        for (int i = 0; i < adjacencyList.get(newCell).size(); i++) {
            Cell destinyCell = adjacencyList.get(newCell).get(i);
            // If the destinyCell hasn't been processed
            if (!settled.contains(destinyCell)) {
                edgeDistance = destinyCell.getCost();
                newDistance = distance.get(newCell) + edgeDistance;

                // If the newDistance is cheaper
                if (newDistance < edgeDistance) {
                    distance.put(destinyCell, newDistance);
                    destinyCell.setCost(newDistance);
                }
                priorityQueue.add(destinyCell);
            }
        }
    }
}
