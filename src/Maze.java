import javax.swing.*;
import java.io.Serial;
import java.util.List;

public class Maze extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    // a maze has 40 * 40 cells
    private final List<Cell> cells;
    private final List<List<Boolean>> isConnected;
    public Maze() {
        MazePuzzle mazePuzzle = new MazePuzzle();
        mazePuzzle.eraseEdges(0.7);
        Graph<Cell, Boolean> mazeGraph = mazePuzzle.getMazeGraph();
        cells = mazeGraph.getVertices();
        isConnected = mazeGraph.getEdges();
    }

    public void drawLines() {
        for (int row = 0; row < MazeConstants.MAZE_SIZE; row++) {
            for (int column = 0; column < MazeConstants.MAZE_SIZE; column++) {
                // open the left side
                if (isConnected.get(row).get(column)) {

                }
            }
        }
    }
}
