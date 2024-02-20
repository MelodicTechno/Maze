import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// a class containing some constants for a universal usage
public class MazeConstants {
    // the size of each cell in the maze
    public static final int CELL_SIZE = 10;
    // the length of the maze
    public static final int MAZE_SIZE = 40;
    public static final int VERTEX_NUMBER = MAZE_SIZE * MAZE_SIZE;
    // the borders
    public static final Border BLANK_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
    public static final Border RIGHT_BORDER = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK);
    public static final Border TOP_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);
    public static final Border BOTTOM_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
    public static final Border LEFT_BORDER = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK);
    // public static final Border SEALED_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);

    public static final String UP_POSITION = "up";
    public static final String DOWN_POSITION = "down";
    public static final String LEFT_POSITION = "left";
    public static final String RIGHT_POSITION = "right";

    // colors
    public static final Color BACKGROUND_COLOR = Color.white;

}
