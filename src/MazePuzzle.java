import java.util.HashSet;
import java.util.Random;

/**
 * The MazePuzzle was used to store the information of the game
 */
public class MazePuzzle {
    private final ListGraph<Cell> mazeGraph;
    private final Cell[][] cells;
    public MazePuzzle() {
        this.mazeGraph = new ListGraph<>();
        this.cells = new Cell[MazeConstants.MAZE_SIZE][MazeConstants.MAZE_SIZE];
        // initialize every cell
        for (int row = 0; row < MazeConstants.MAZE_SIZE; row++) {
            for (int column = 0; column < MazeConstants.MAZE_SIZE; column++) {
                cells[row][column] = new Cell(row, column);
                // add the cells to the graph
                mazeGraph.addVertex(cells[row][column]);
                if (row - 1 >= 0) {
                    mazeGraph.addEdge(cells[row - 1][column], cells[row][column]);
                }
                if (row + 1 < MazeConstants.MAZE_SIZE) {
                    mazeGraph.addEdge(cells[row + 1][column], cells[row][column]);
                }
                if (column - 1 >= 0) {
                    mazeGraph.addEdge(cells[row][column - 1], cells[row][column]);
                }
                if (column + 1 < MazeConstants.MAZE_SIZE) {
                    mazeGraph.addEdge(cells[row][column + 1], cells[row][column]);
                }
            }
        }
    }
    public ListGraph<Cell> getMazeGraph() {
        return this.mazeGraph;
    }

    public Cell[][] getCells () {
        return this.cells;
    }

    // erase the edges
    public void eraseEdges(double extent) {
        
    }
}
