import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Maze extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    public Maze() {
        super.setLayout(new GridLayout(MazeConstants.MAZE_SIZE, MazeConstants.MAZE_SIZE));
        super.setPreferredSize(new Dimension(MazeConstants.MAZE_SIZE * MazeConstants.CELL_SIZE,
                MazeConstants.MAZE_SIZE * MazeConstants.CELL_SIZE));
        MazePuzzle mazePuzzle = new MazePuzzle();
        mazePuzzle.eraseEdges(0.7);
        // a maze has 40 * 40 cells
        Cell[][] cells = mazePuzzle.getCells();
        for (int row = 0; row < MazeConstants.MAZE_SIZE; row++) {
            for (int column = 0; column < MazeConstants.MAZE_SIZE; column++) {
                super.add(cells[row][column]);
            }
        }
    }

}
