package bbb.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Yard {
    private final Grid grid;
    private final Map<Symbol,Integer> toyPartsRemaining;

    public Yard(int gridSize) {
        grid = new Grid(gridSize);
        toyPartsRemaining = new HashMap<>();
        buryToys();
    }

    private void buryToys() {
        for (Toy toy : Toy.values()) {
            while (true) {
                YardCoordinate start = grid.getRandomCoordinate(List.of(Symbol.GRASS));
                Direction direction = Direction.getRandomDirection();
                if (addToyToGrid(toy, start, direction)) {
                    toyPartsRemaining.put(toy.getSymbol(), toy.getLength());
                    break;
                }
            }
        }
    }

    private boolean addToyToGrid(Toy toy, YardCoordinate start, Direction direction) {
        char row = start.getRow();
        int column = start.getColumn();

        List<YardCoordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < toy.getLength(); i++) {
            YardCoordinate coordinate = new YardCoordinate(row, column);
            if (!grid.isOnGrid(coordinate) || grid.getCell(coordinate) != Symbol.GRASS)
                return false;

            if (direction == Direction.HORIZONTAL)
                column++;
            else
                row++;

            coordinates.add(coordinate);
        }

        coordinates.forEach(coord -> grid.setCell(coord, toy.getSymbol()));
        return true;
    }

    public YardCoordinate getRandomCoordinate(List<Symbol> include) {
        return grid.getRandomCoordinate(include);
    }

    public DigResult digAt(YardCoordinate coordinate) {
        if (!grid.isOnGrid(coordinate))
            return DigResult.INVALID;
        
        Symbol symbol = grid.getCell(coordinate);
        if (symbol == Symbol.GRASS) {
            grid.setCell(coordinate, Symbol.HOLE);
            return DigResult.NOTHING;
        } else if (toyPartsRemaining.containsKey(symbol)) {
            int partsRemaining = toyPartsRemaining.get(symbol) - 1;
            toyPartsRemaining.put(symbol, partsRemaining);
            grid.setCell(coordinate, Symbol.PART);
            return partsRemaining == 0 ? DigResult.FULL_TOY : DigResult.TOY_PART;
        }
        return DigResult.INVALID;
    }

    public boolean allToysFound() {
        return toyPartsRemaining.values().stream().allMatch(partsRemaining -> partsRemaining == 0);
    }

    public String buildYardString(boolean maskToys) {
        StringBuilder sb = new StringBuilder();
        int size = grid.getSize();
        
        // Column headers
        sb.append(" ");
        for (int col = 0; col < size; col++) {
            sb.append(col);
        }
        sb.append("\n");
        
        // Grid rows
        for (int row = 0; row < size; row++) {
            sb.append((char) ('A' + row));
            for (int col = 0; col < size; col++) {
                YardCoordinate coord = new YardCoordinate((char) ('A' + row), col);
                Symbol cell = grid.getCell(coord);
                
                if (maskToys && toyPartsRemaining.containsKey(cell))
                    sb.append(Symbol.GRASS.getAsciiChar());
                else
                    sb.append(cell.getAsciiChar());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
