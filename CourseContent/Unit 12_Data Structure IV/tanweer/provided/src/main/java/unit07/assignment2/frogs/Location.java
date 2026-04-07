package unit07.assignment2.frogs;

public class Location {
    private int row, col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location locationObj = (Location) obj;
            return this.row == locationObj.row && this.col == locationObj.col;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public static void main(String[] args) {

    }
}
