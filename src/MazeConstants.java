import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// a class containing some constants for a universal usage
public class MazeConstants {
    // the size of each cell in the maze
    public static final int CELL_SIZE = 1;
    // the length of the maze
    public static final int MAZE_SIZE = 40;

    // the borders
    Border rightBorder = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK);
    Border topBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);
    Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
    Border leftBorder = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK);
}
