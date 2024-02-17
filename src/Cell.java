import javax.swing.*;
import java.io.Serial;

public class Cell extends JTextField {
    @Serial
    private static final long serialVersionUID = 1L;
    // the data of cells should be described with a matrix
    private int row;
    private int column;

    // if it is connected with other cells
    private boolean IsConnectedUp;
    private boolean IsConnectedDown;
    private boolean IsConnectedLeft;
    private boolean IsConnectedRight;

    // constructor
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // using the boarder to show if it is opened
    public void makeBoarder() {

    }
}
