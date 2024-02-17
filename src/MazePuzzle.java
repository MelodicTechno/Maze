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
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                cells[10 * row + column] = new Cell(row, column);
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
        int eraseIndex1 = randomIndex.nextInt(MazeConstants.MAZE_SIZE);
        int eraseIndex2 = randomIndex.nextInt(MazeConstants.MAZE_SIZE);
        int eraseTimes = (int) (MazeConstants.VERTEX_NUMBER * extent);
        for (int time = 0; time < eraseTimes; time++) {
            mazeGraph.addEdge(eraseIndex1, eraseIndex2, false);
        }
    }
}
