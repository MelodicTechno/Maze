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
        this.cells = mazeGraph.getVertices();
        this.isConnected = mazeGraph.getEdges();
        this.drawLines();
        for (Cell cell : cells) {
            super.add(cell);
        }
    }

    public void drawLines() {
        for (int row = 0; row < MazeConstants.MAZE_SIZE; row++) {
            for (int column = 0; column < MazeConstants.MAZE_SIZE; column++) {
                if (!isConnected.get(row).get(column)) {
                    Cell cell1 = this.cells.get(row);
                    Cell cell2 = this.cells.get(column);
                    if (cell1.isNeighborTo(cell2)) {
                        String position = cell1.getPositionOfNeighbor(cell2);
                        cell1.makeBoarder(position);
                    }
                }
            }
        }
    }
}
