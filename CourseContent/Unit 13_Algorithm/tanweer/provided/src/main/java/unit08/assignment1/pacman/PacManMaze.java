package unit08.assignment1.pacman;

import java.util.LinkedList;
import java.util.List;

import unit08.weighted.WAdjacencyGraph;

public class PacManMaze extends WAdjacencyGraph<Cell> {
    private Cell pacMan;
    private List<Cell> powerPellets;

    public PacManMaze() {
        this.pacMan = null;
        this.powerPellets = new LinkedList<>();
    }

    @Override
    public void add(Cell cell) {
        super.add(cell);
        if(cell.getType() == CellType.PAC_MAN) {
            this.pacMan = cell;
        } else if(cell.getType() == CellType.POWER_PELLET) {
            powerPellets.add(cell);
        }
    }

    public Cell getPacMan() {
        return pacMan;
    }

    public List<Cell> getPowerPellets() {
        return powerPellets;
    }
}
