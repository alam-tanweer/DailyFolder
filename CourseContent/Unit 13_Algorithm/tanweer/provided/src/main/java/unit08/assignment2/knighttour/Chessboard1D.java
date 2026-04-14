package unit08.assignment2.knighttour;

import java.util.Arrays;

public class Chessboard1D {
    private final int n;
    private final int[] board;
    private int moves;

    public Chessboard1D(int n) {
        this.n = n;
        this.board = new int[n*n];
        this.moves = 0;
    }

    public Chessboard1D(Chessboard1D template) {
        this.n = template.n;
        this.board = Arrays.copyOf(template.board, template.board.length);
        this.moves = template.moves;
    }

    public boolean makeMove(int row, int col) {
        int index = row * n + col;
        if(row < 0 || row >= n 
            || col < 0 || col >= n 
            || board[index] != 0) {
            return false;
        } else {
            moves++;
            board[index] = moves;
            return true;
        }
    }
    
    /**
     * Returns the number of moves made on this board.
     * 
     * @return The number of moves made on this board.
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Returns true if every square has a move.
     * 
     * @return True if every square has a move, and false otherwise.
     */
    public boolean isFull() {
        return moves == (n * n);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                int index = row * n + col;
                builder.append("[");
                builder.append(String.format("%3d", board[index]));
                builder.append("]");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Chessboard1D board = new Chessboard1D(8);
        board.makeMove(5, 7);
        System.out.println(board);
    }
}
