package unit07.assignment2.gvt;

public class Cell {
    private final int row, col;
    private boolean troll;

    public Cell(int row, int col, boolean troll) {
        this.row = row;
        this.col = col;
        this.troll = troll;

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isTroll() {
        return troll;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}
