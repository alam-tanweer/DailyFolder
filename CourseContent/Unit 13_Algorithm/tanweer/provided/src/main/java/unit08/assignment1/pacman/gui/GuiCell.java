package unit08.assignment1.pacman.gui;

public class GuiCell {
    private final int row;
    private final int col;
    private GuiCellType state;
    private final int hashCode;

    public GuiCell(int row, int col) {
        this(row, col, GuiCellType.WALL);
    }

    public GuiCell(int row, int col, GuiCellType state) {
        this.row = row;
        this.col = col;
        this.state = state;
        this.hashCode = (int)(Math.pow(29, row) + Math.pow(31, col));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public GuiCellType getState() {
        return state;
    }

    public void toggle() {
        state = state.next();
    }

    public boolean isEmpty() {
        return state == GuiCellType.WALL;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GuiCell) {
            GuiCell other = (GuiCell)obj;
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
        return state.toString() + "-" + row + "-" + col;
    }
}
