package unit13;

public class Box {
    private final int row;
    private final int col;
    private final int width;
    private final int height;

    public Box(int row, int col, int width, int height) {
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(Box other) {
        return other.row >= row 
            && other.row <= (row + height) 
            && other.col >= col 
            && other.col <= (col + width);
    }
}
