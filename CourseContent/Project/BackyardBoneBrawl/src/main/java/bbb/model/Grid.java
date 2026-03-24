package bbb.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final Symbol[][] cells;

    public Grid(int size) {
        cells = new Symbol[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = Symbol.GRASS;
            }
        }
    }

    public YardCoordinate getRandomCoordinate(List<Symbol> include) {
        List<YardCoordinate> emptyCoordinates = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (include.contains(cells[i][j])) {
                    emptyCoordinates.add(new YardCoordinate(indexToRowChar(i), j));
                }
            }
        }
        int randomIndex = (int) (Math.random() * emptyCoordinates.size());
        return emptyCoordinates.get(randomIndex);
    }

    private int rowCharToIndex(char row) {
        return row - 'A';
    }

    private char indexToRowChar(int index) {
        return (char) ('A' + index);
    }

    public boolean isOnGrid(YardCoordinate coordinate) {
        int rowIndex = rowCharToIndex(coordinate.getRow());
        int colIndex = coordinate.getColumn();

        if (rowIndex < 0 || rowIndex >= cells.length || colIndex < 0 || colIndex >= cells.length)
            return false;

        return true;
    }

    public Symbol getCell(YardCoordinate coordinate) {
        int rowIndex = rowCharToIndex(coordinate.getRow());
        return cells[rowIndex][coordinate.getColumn()];
    }

    public void setCell(YardCoordinate coordinate, Symbol symbol) {
        int rowIndex = rowCharToIndex(coordinate.getRow());
        cells[rowIndex][coordinate.getColumn()] = symbol;
    }

    public int getSize() {
        return cells.length;
    }
}
