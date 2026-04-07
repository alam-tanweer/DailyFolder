package unit07.assignment2.gvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import unit07.Vertex;

public class GvT {
    private AdjacencyGraph<Cell> graph;
    private Set<Cell> trollCells;
    private Cell startCell;
    private Cell endCell;

    public GvT(String filename) throws IOException {
        try (FileReader fr = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fr)) {
            this.graph = new AdjacencyGraph<>();
            String[] rc = reader.readLine().split(" ");
            int ROWS = Integer.parseInt(rc[0]);
            int COLS = Integer.parseInt(rc[1]);
            Cell[][] cells = new Cell[ROWS][COLS];
            String line = null;
            int row = 0;
            this.trollCells = new HashSet<>();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int col = 0; col < tokens.length; col++) {
                    char ch = tokens[col].charAt(0);
                    if (ch == 'T') {
                        cells[row][col] = new Cell(row, col, true);
                        trollCells.add(cells[row][col]);
                    } else {
                        cells[row][col] = new Cell(row, col, false);
                    }
                    graph.add(cells[row][col]);
                    if (col > 0) {
                        graph.connectUndirected(cells[row][col - 1], cells[row][col]);
                    }
                    if (row > 0) {
                        graph.connectUndirected(cells[row - 1][col], cells[row][col]);
                    }
                }
                row++;
            }
            this.startCell = cells[0][0];
            this.endCell = cells[ROWS - 1][COLS - 1];
        }
    }

    private Set<Vertex<Cell>> getTrollVertices() {
        Set<Vertex<Cell>> trolls = new HashSet<>();
        for (Cell troll : trollCells) {
            trolls.add(graph.getVertex(troll));
        }
        return trolls;
    }

    public List<Cell> dfPathMage() {
        Vertex<Cell> s = graph.getVertex(startCell);
        Vertex<Cell> e = graph.getVertex(endCell);
        Set<Vertex<Cell>> visited = getTrollVertices();
        visited.add(s);
        return graph.visitDFPath(s, e, visited);
    }

    public List<Cell> dfPathFighter() {
        Vertex<Cell> s = graph.getVertex(startCell);
        Vertex<Cell> e = graph.getVertex(endCell);
        Set<Vertex<Cell>> trollVertices = getTrollVertices();
        for (Cell trollCell : this.trollCells) {
            Vertex<Cell> trollVertex = graph.getVertex(trollCell);
            Set<Vertex<Cell>> visited = new HashSet<>(trollVertices);
            visited.add(s);
            visited.remove(trollVertex);
            List<Cell> path = graph.visitDFPath(s, e, visited);
            visited.add(trollVertex);
            if (path != null) {
                return path;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        GvT gvt = new GvT("data/dfs/graph4_fighter.txt");
        System.out.println(gvt.dfPathFighter());
        // [(0,0), (0,1), (0,2), (1,2), (2,2), (3,2), (3,1), (4,1), (5,1), (5,2), (5,3),
        // (5,4)]

    }
}
