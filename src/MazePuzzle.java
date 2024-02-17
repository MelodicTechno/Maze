import java.util.HashSet;
import java.util.Random;

/**
 * The MazePuzzle was used to store the information of the game
 */
public class MazePuzzle {
    private final Graph<Cell, Boolean> mazeGraph;
    public MazePuzzle() {
        int size = MazeConstants.VERTEX_NUMBER;
        Boolean[][] isConnected = new Boolean[size][size];
        Cell[] cells = new Cell[size];
        for (int row = 0; row < MazeConstants.MAZE_SIZE; row++) {
            for (int column = 0; column < MazeConstants.MAZE_SIZE; column++) {
                cells[40 * row + column] = new Cell(row, column);
            }
        }
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                isConnected[row][column] = true;
            }
        }
        this.mazeGraph = new Graph<>(cells, isConnected);
    }
    public Graph<Cell, Boolean> getMazeGraph() {
        return this.mazeGraph;
    }

    // erase the edges
    public void eraseEdges(double extent) {
        Random randomIndex = new Random();
        HashSet<Integer> addedIndexes = new HashSet<>();

        int eraseTimes = (int) (MazeConstants.VERTEX_NUMBER * extent);
        System.out.println("erase " + eraseTimes + " times" );
        int times = 0;
        while (times < eraseTimes) {
            int eraseIndex1 = randomIndex.nextInt(0, MazeConstants.VERTEX_NUMBER);
            int eraseIndex2 = randomIndex.nextInt(0, MazeConstants.VERTEX_NUMBER);
            if (addedIndexes.contains(eraseIndex1) || addedIndexes.contains(eraseIndex2)) {
                continue;
            }
            mazeGraph.addEdge(eraseIndex1, eraseIndex2, false);
            times++;
            addedIndexes.add(eraseIndex1);
            addedIndexes.add(eraseIndex2);
        }
        System.out.println("all erasing finished");
    }
}
