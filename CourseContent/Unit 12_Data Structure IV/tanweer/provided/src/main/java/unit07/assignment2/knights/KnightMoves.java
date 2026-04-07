package unit07.assignment2.knights;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import unit07.AdjacencyGraph;
import unit07.Graph;

public class KnightMoves {
    // the rows to which a knight can move from its current position
    private static final int[] ROW_DIFFS = { -2, -2, -1, -1, 1, 1, 2, 2 };
    // the cols to which a knight can move from its current position
    private static final int[] COL_DIFFS = { -1, 1, -2, 2, -2, 2, -1, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get the size
        int rows = 0;
        int cols = 0;
        boolean noSize = true;
        while (noSize) {
            try {
                System.out.print("Enter the number of rows and columns: ");
                rows = scanner.nextInt();
                cols = scanner.nextInt();
                if (rows < 3 || cols < 3) {
                    System.err.println(
                            "Rows and columns must be greater than 3.");
                } else {
                    noSize = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter valid integers.");
            }
            scanner.nextLine();
        }

        // build the graph
        Graph<Square> chessboard = new AdjacencyGraph<>();
        // add the squares
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Square square = new Square(row, col);
                chessboard.add(square);
            }
        }
        // connect the squares
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Square square = new Square(row, col);
                for (int i = 0; i < ROW_DIFFS.length; i++) {
                    Square neighbor = new Square(row + ROW_DIFFS[i],
                            col + COL_DIFFS[i]);
                    if (chessboard.contains(neighbor)) {
                        // System.out.println("connecting: " + square +
                        // " and " + neighbor); // debugging
                        chessboard.connectUndirected(square, neighbor);
                    }
                }
            }
        }

        boolean noQuit = true;
        while (noQuit) {
            System.out.print("Enter the start and end coordinates: ");
            String coords = scanner.nextLine();
            if (coords.equals("quit")) {
                noQuit = false;
            } else {
                String[] tokens = coords.split(" ");
                if (tokens.length != 4) {
                    System.err.println("Please enter valid coordinates.");
                } else {
                    Square start = new Square(tokens[0], tokens[1]);
                    Square end = new Square(tokens[2], tokens[3]);
                    List<Square> dfPath = chessboard.dfPath(start, end);
                    System.out.println(dfPath);
                    List<Square> bfPath = chessboard.bfPath(start, end);
                    System.out.println(bfPath);
                }
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

}
