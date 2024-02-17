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
    public static Border SEALED_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
    public static Border RIGHT_BORDER = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.WHITE);
    public static Border TOP_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE);
    public static Border BOTTOM_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
    public static Border LEFT_BORDER = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.WHITE);
}
