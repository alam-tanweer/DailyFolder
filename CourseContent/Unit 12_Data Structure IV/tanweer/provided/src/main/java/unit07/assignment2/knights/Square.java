package unit07.assignment2.knights;

public class Square {
    private final int row;
    private final int column;
    private final String stringified;
    private final int hashCode;

    public Square(int row, int column) {
        this.row = row;
        this.column = column;
        this.stringified = "(" + this.row + ", " + this.column + ")";
        this.hashCode = stringified.hashCode();
    }

    public Square(String row, String col) {
        this(Integer.parseInt(row), Integer.parseInt(col));
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return stringified;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Square) {
            Square other = (Square) obj;
            return this.row == other.row && this.column == other.column;
        } else {
            return false;
        }
    }

}
