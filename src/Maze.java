import javax.swing.*;
import java.io.Serial;

public class Maze extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    // a maze has 40 * 40 cells
    private final Cell[][] cells = new Cell[MazeConstants.MAZE_SIZE][MazeConstants.MAZE_SIZE];

}
