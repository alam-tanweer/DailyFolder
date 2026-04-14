package unit08.assignment1.pacman.gui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import unit08.weighted.WAdjacencyGraph;
import unit08.weighted.WVertex;

public class MazeGraph extends WAdjacencyGraph<GuiCell> {

    private void connectIfExists(GuiCell cell, int row, int col) {
        GuiCell neighbor = new GuiCell(row, col);
        if(contains(neighbor)) {
            System.out.println("Connecting " + cell + " to " + neighbor);
            connect(cell, neighbor, 1);
        }
    }

    public void connectCells() {
        for (GuiCell cell : getValues()) {
            connectIfExists(cell, cell.getRow() - 1, cell.getCol());
            connectIfExists(cell, cell.getRow() + 1, cell.getCol());
            connectIfExists(cell, cell.getRow(), cell.getCol() - 1);
            connectIfExists(cell, cell.getRow(), cell.getCol() + 1);
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (FileWriter fw = new FileWriter(filename);
            PrintWriter printer = new PrintWriter(fw)) {
            for (GuiCell cell : getValues()) {
                WVertex<GuiCell> vertex = getVertex(cell);
                StringBuilder builder = new StringBuilder();
                builder.append(vertex.getValue());
                for(WVertex<GuiCell> n : vertex.getNearestNeighbors()) {
                    builder.append(" ");
                    builder.append(n.getValue());
                }
                printer.println(builder.toString());
            }
            printer.flush();
        }
    }
}
