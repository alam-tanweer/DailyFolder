package unit07.assignment2.frogs;

import java.util.HashMap;
import java.util.Map;

public class Hole {
    private final int row, col;

    public Hole(int row, int col) {
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
        if (obj instanceof Hole) {
            Hole holeObj = (Hole) obj;
            return this.row == holeObj.row && this.col == holeObj.col;
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
        Map<Hole, Integer> map = new HashMap<>();
        map.put(new Hole(0, 0), 0);
        map.put(new Hole(0, 3), 0);
        map.put(new Hole(5, 2), 5);
        System.out.println(map.containsKey(new Hole(5, 2))); // true
        System.out.println(map.get(new Hole(5, 2))); // 5
    }
}