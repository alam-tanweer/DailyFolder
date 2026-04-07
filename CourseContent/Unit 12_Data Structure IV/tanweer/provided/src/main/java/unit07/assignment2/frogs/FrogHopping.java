package unit07.assignment2.frogs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrogHopping {
    private AdjacencyGraph<Hole> graph;
    private char[][] arrayBoard;
    private final int ROWS, COLS;

    public FrogHopping(String filename) throws IOException {
        try (FileReader fr = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fr)) {
            graph = new AdjacencyGraph<>();

            String[] rc = reader.readLine().split(" ");
            ROWS = Integer.parseInt(rc[0]);
            COLS = Integer.parseInt(rc[1]);

            arrayBoard = new char[ROWS][COLS];
            String line = null;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int col = 0; col < tokens.length; col++) {
                    arrayBoard[row][col] = tokens[col].charAt(0);
                    if (arrayBoard[row][col] == 'H') {
                        graph.add(new Hole(row, col));
                    }
                }
                row++;
            }
            connectVertices();
        }
    }

    private void connectVertices() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (arrayBoard[r][c] == 'H') {
                    if (r + 2 < ROWS && c - 2 >= 0 && arrayBoard[r + 2][c - 2] == 'H'
                            && arrayBoard[r + 1][c - 1] == 'P') {
                        graph.connectUndirected(new Hole(r, c), new Hole(r + 2, c - 2)); // (r, c) <-->(r+2, c-2)
                    }
                    if (r + 2 < ROWS && arrayBoard[r + 2][c] == 'H' && arrayBoard[r + 1][c] == 'P') {
                        graph.connectUndirected(new Hole(r, c), new Hole(r + 2, c)); // (r, c) <-->(r+2, c)
                    }
                    if (r + 2 < ROWS && c + 2 < COLS && arrayBoard[r + 2][c + 2] == 'H'
                            && arrayBoard[r + 1][c + 1] == 'P') {
                        graph.connectUndirected(new Hole(r, c), new Hole(r + 2, c + 2)); // (r, c) <-->(r+2, c+2)
                    }
                    if (c + 2 < COLS && arrayBoard[r][c + 2] == 'H' && arrayBoard[r][c + 1] == 'P') {
                        graph.connectUndirected(new Hole(r, c), new Hole(r, c + 2)); // (r, c) <-->(r, c+2)
                    }
                }
            }
        }
    }

    // The frog can't jump to a hole which was visited before
    public List<Hole> dfPathV0(Hole start, Hole end) {
        return graph.dfPath(start, end);
    }

    // The frog can't jump over the same peg more than once
    public List<Hole> dfPathV1(Hole start, Hole end) {
        Map<Hole, Vertex<Hole>> vertices = graph.getVertices();
        Vertex<Hole> s = vertices.get(start);
        Vertex<Hole> e = vertices.get(end);
        Set<Hole> pegs = new HashSet<>();
        return visitDFPathV1(s, e, pegs);
    }

    private List<Hole> visitDFPathV1(Vertex<Hole> v, Vertex<Hole> e,
            Set<Hole> pegs) {

        if (v == e) {
            List<Hole> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        } else {
            Hole vHole = v.getValue();
            for (Vertex<Hole> neighbor : v.getNeighbors()) {
                Hole nbrHole = neighbor.getValue();
                Hole peg = new Hole((vHole.getRow() + nbrHole.getRow()) / 2,
                        (vHole.getCol() + nbrHole.getCol()) / 2);
                if (!pegs.contains(peg)) {
                    pegs.add(peg);
                    List<Hole> path = visitDFPathV1(neighbor, e, pegs);
                    if (path != null) {
                        path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public String toString() {
        String string = "";
        Map<Hole, Vertex<Hole>> vertices = graph.getVertices();
        for (Hole loc : vertices.keySet()) {
            string += loc + ": " + vertices.get(loc).getNeighbors() + "\n";
        }
        return string;
    }

    public static void main(String[] args) throws IOException {
        FrogHopping frog = new FrogHopping("data_2215/frog_3.txt");
        System.out.println("The frog game graph representation:");
        System.out.println(frog);

        Hole start = new Hole(2, 1);
        Hole end = new Hole(0, 5);
        System.out.println(frog.dfPathV0(start, end)); // [(2,1), (0,3), (2,5), (2,3), (0,5)]
        System.out.println(frog.dfPathV1(start, end)); // [(2,1), (0,3), (2,5), (2,3), (0,3), (0,5)]

    }
}
