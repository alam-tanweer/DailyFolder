package unit08.assignment1.pacman;

public class Cell {
    private final int row;
    private final int col;
    private final CellType type;
    private final int hashCode;

    public Cell(int row, int col, CellType state) {
        this.row = row;
        this.col = col;
        this.type = state;
        this.hashCode = (int)(Math.pow(29, row) + Math.pow(31, col));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellType getType() {
        return type;
    }

    public boolean isGhost() {
        return type == CellType.GHOST;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cell) {
            Cell other = (Cell)obj;
            return this.row == other.row && this.col == other.col;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return type.toString() + "-" + row + "-" + col;
    }
}
