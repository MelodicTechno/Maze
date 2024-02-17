import javax.swing.*;
import javax.swing.border.Border;
import java.io.Serial;

public class Cell extends JTextField {
    @Serial
    private static final long serialVersionUID = 1L;
    // the data of cells should be described with a matrix
    private final int row;
    private final int column;

    // constructor
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setText("");
        super.setEditable(false);
        super.setBackground(MazeConstants.BACKGROUND_COLOR);
        super.setBorder(MazeConstants.BLANK_BORDER);
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    // using the boarder to show if it is opened
    public void makeBoarder(String direction) {
        Border oldBorder = super.getBorder();
        Border newBorder;
        switch (direction) {
            case (MazeConstants.UP_POSITION) :
                newBorder = BorderFactory.createCompoundBorder(MazeConstants.TOP_BORDER, oldBorder);
                super.setBorder(newBorder);
                break;
            case (MazeConstants.DOWN_POSITION) :
                newBorder = BorderFactory.createCompoundBorder(MazeConstants.BOTTOM_BORDER, oldBorder);
                super.setBorder(newBorder);
                break;
            case (MazeConstants.LEFT_POSITION) :
                newBorder = BorderFactory.createCompoundBorder(MazeConstants.LEFT_BORDER, oldBorder);
                super.setBorder(newBorder);
                break;
            case (MazeConstants.RIGHT_POSITION) :
                newBorder = BorderFactory.createCompoundBorder(MazeConstants.RIGHT_BORDER, oldBorder);
                super.setBorder(newBorder);
                break;
        }
    }
    // check if the cell is beside other cells
    public boolean isNeighborTo(Cell anotherCell) {
        int rowOfAnotherCell = anotherCell.getRow();
        int columnOfAnotherCell = anotherCell.getColumn();
        boolean flag1 = rowOfAnotherCell - this.row == 0;
        boolean flag2 = Math.abs(rowOfAnotherCell - this.row) == 1;
        boolean flag3 = columnOfAnotherCell - this.column == 0;
        boolean flag4 = Math.abs(columnOfAnotherCell - this.column) == 1;
        return (flag1 && flag4) || (flag2 && flag3);
    }

    // check the position of its neighbor, if the neighbor exists.
    public String getPositionOfNeighbor(Cell anotherCell) {
        if (!this.isNeighborTo(anotherCell)) {
            throw new RuntimeException("The cell said, \"You are not my neighbor!\"");
        }
        int rowOfAnotherCell = anotherCell.getRow();
        int columnOfAnotherCell = anotherCell.getColumn();
        int flag1 = rowOfAnotherCell - this.row;
        int flag2 = columnOfAnotherCell - this.column;
        if (flag1 > 0) {
            return MazeConstants.UP_POSITION;
        }
        else if (flag1 < 0) {
            return MazeConstants.DOWN_POSITION;
        }
        else if (flag2 < 0) {
            return MazeConstants.LEFT_POSITION;
        }
        else {
            return MazeConstants.RIGHT_POSITION;
        }
    }
}
