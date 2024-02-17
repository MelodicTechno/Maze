import javax.swing.*;
import javax.swing.border.Border;
import java.io.Serial;

public class Cell extends JTextField {
    @Serial
    private static final long serialVersionUID = 1L;
    // the data of cells should be described with a matrix
    private final int row;
    private final int column;

    // if it is connected with other cells
    private boolean IsConnectedUp;
    private boolean IsConnectedDown;
    private boolean IsConnectedLeft;
    private boolean IsConnectedRight;

    // constructor
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        // sealed as default
        super.setBorder(MazeConstants.SEALED_BORDER);
    }

    // using the boarder to show if it is opened
    public void makeBoarder(String direction) {
        Border oldBorder = super.getBorder();
        Border newBorder = switch (direction) {
            case "up" -> BorderFactory.createCompoundBorder(MazeConstants.TOP_BORDER, oldBorder);
            case "down" -> BorderFactory.createCompoundBorder(MazeConstants.BOTTOM_BORDER, oldBorder);
            case "left" -> BorderFactory.createCompoundBorder(MazeConstants.LEFT_BORDER, oldBorder);
            case "right" -> BorderFactory.createCompoundBorder(MazeConstants.RIGHT_BORDER, oldBorder);
            default -> null;
        };
        super.setBorder(newBorder);
    }
}
