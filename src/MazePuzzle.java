import java.util.HashSet;
import java.util.Random;

/**
 * The MazePuzzle was used to store the information of the game
 */
public class MazePuzzle {
    private final ListGraph<Cell> mazeGraph;
    private final Cell[][] cells;
    private int edges;
    public MazePuzzle() {
        this.mazeGraph = new ListGraph<>();
        this.cells = new Cell[MazeConstants.MAZE_SIZE][MazeConstants.MAZE_SIZE];
        this.edges = 0;
        // initialize every cell
        for (int row = 0; row < MazeConstants.MAZE_SIZE; row++) {
            for (int column = 0; column < MazeConstants.MAZE_SIZE; column++) {
                cells[row][column] = new Cell(row, column);
                if (row == 0) {
                    cells[row][column].setBorder(MazeConstants.TOP_BORDER);
                }
                else if (row == MazeConstants.MAZE_SIZE - 1) {
                    cells[row][column].setBorder(MazeConstants.BOTTOM_BORDER);
                }
                if (column == 0) {
                    cells[row][column].setBorder(MazeConstants.LEFT_BORDER);
                }
                else if (column == MazeConstants.MAZE_SIZE - 1) {
                    cells[row][column].setBorder(MazeConstants.RIGHT_BORDER);
                }
                // add the cells to the graph
                mazeGraph.addVertex(cells[row][column]);
                if (row - 1 >= 0) {
                    mazeGraph.addEdge(cells[row - 1][column], cells[row][column]);
                    this.edges++;
                }
                if (row + 1 < MazeConstants.MAZE_SIZE) {
                    mazeGraph.addEdge(cells[row + 1][column], cells[row][column]);
                    this.edges++;
                }
                if (column - 1 >= 0) {
                    mazeGraph.addEdge(cells[row][column - 1], cells[row][column]);
                    this.edges++;
                }
                if (column + 1 < MazeConstants.MAZE_SIZE) {
                    mazeGraph.addEdge(cells[row][column + 1], cells[row][column]);
                    this.edges++;
                }
            }
        }
    }

    public Cell[][] getCells () {
        return this.cells;
    }

    // erase the edges
    public void eraseEdges(double extent) {
        HashSet<Cell> addedCells = new HashSet<>();
        Random cellPicker = new Random();
        int times = (int) (this.edges * extent * 4);
        for (int time = 0; time < times; time++) {
            Cell cell1 = cells[cellPicker.nextInt(MazeConstants.MAZE_SIZE)]
                    [cellPicker.nextInt(MazeConstants.MAZE_SIZE)];
            if (addedCells.contains(cell1)) {
                continue;
            }
            int newRow = cell1.getRow() + cellPicker.nextInt(-1, 1);
            int newColumn = cell1.getColumn() + cellPicker.nextInt(-1, 1);
            if (newRow < 0 || newRow >= MazeConstants.MAZE_SIZE || newColumn < 0
                    || newColumn >= MazeConstants.MAZE_SIZE) {
                continue;
            }
            Cell cell2 = cells[newRow][newColumn];
            if (!cell1.isNeighborTo(cell2) || addedCells.contains(cell2)) {
                continue;
            }
            String position = cell1.getPositionOfNeighbor(cell2);
            addedCells.add(cell1);
            addedCells.add(cell2);
            cell1.makeBoarder(position);
            this.mazeGraph.removeEdge(cell1, cell2);
        }
    }

    public ListGraph<Cell> getMazeGraph() {
        return this.mazeGraph;
    }
}
