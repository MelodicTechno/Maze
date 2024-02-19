public class CellTester {
    public static void main(String[] args) {
        Cell cell1 = new Cell(1, 1);
        Cell cell2 = new Cell(1, 2);
        cell1.isNeighborTo(cell2);
    }
}
