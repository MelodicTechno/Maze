import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.List;

public class Maze extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    // a maze has 40 * 40 cells

    public Maze() {
        super.setLayout(new GridLayout(MazeConstants.MAZE_SIZE, MazeConstants.MAZE_SIZE));
        super.setPreferredSize(new Dimension(MazeConstants.MAZE_SIZE * MazeConstants.CELL_SIZE,
                MazeConstants.MAZE_SIZE * MazeConstants.CELL_SIZE));
        MazePuzzle mazePuzzle = new MazePuzzle();
        mazePuzzle.eraseEdges(0.7);
        ListGraph<Cell> mazeGraph = mazePuzzle.getMazeGraph();

        this.drawLines();

    }

    public void drawLines() {

    }
}
