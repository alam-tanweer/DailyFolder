package bbb.model;

public class YardCoordinate {
    private final char row;
    private final int column;

    public YardCoordinate(char row, int column) {
        this.row = row;
        this.column = column;
    }

    public YardCoordinate(String coordinate) {
        this(coordinate.charAt(0), Integer.parseInt(coordinate.substring(1)));
    }

    public char getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof YardCoordinate))
            return false;

        YardCoordinate other = (YardCoordinate)o;
        return this.row == other.row && this.column == other.column;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(row) * 31 + Integer.hashCode(column);
    }

    @Override
    public String toString() {
        return row + Integer.toString(column);
    }
}
