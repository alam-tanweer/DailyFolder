package unit08.assignment2.knighttour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import unit08.backtracker.Backtracker;
import unit08.backtracker.Configuration;


public class KnightTourConfiguration 
    implements Configuration<KnightTourConfiguration> {

    private static final int[] ROW_DIFFS = {-2, -2,  2,  2, -1, -1,  1,  1};
    private static final int[] COL_DIFFS = {-1,  1, -1,  1, -2,  2, -2,  2};

    private final Chessboard board;
    private final int row;
    private final int col;
    private final boolean valid;

    public KnightTourConfiguration(Chessboard board, int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;
        // this.valid = board.makeMove(row, col);
        this.valid = true;
    }

    @Override
    public Collection<KnightTourConfiguration> getSuccessors() {
        List<KnightTourConfiguration> successors = new ArrayList<>();
        
        Chessboard nextMove = new Chessboard(board);
        for(int i=0; i<ROW_DIFFS.length; i++) {
            int nextRow = row + ROW_DIFFS[i];
            int nextCol = col + COL_DIFFS[i];
            if(nextMove.makeMove(nextRow, nextCol)) {
                successors.add(new KnightTourConfiguration(nextMove, nextRow, 
                    nextCol));
                nextMove = new Chessboard(board);
            }
        }

        // if(successors.size() == 0) {
        //     System.out.println(board);
        //     System.exit(1);
        // }

        return successors;
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public boolean isGoal() {
        return board.isFull();
    }

    @Override
    public String toString() {
        return board.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        Chessboard board = new Chessboard(n);

        System.out.print("Enter starting position: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        board.makeMove(row, col);

        scanner.close();

        Backtracker<KnightTourConfiguration> backtracker = 
            new Backtracker<>(false);
        KnightTourConfiguration config = new KnightTourConfiguration(board,
            row, col);
        KnightTourConfiguration solution = backtracker.solve(config);
        if(solution == null) {
            System.out.println("no solution");
        } else {
            System.out.println(solution);
        }
    }
}
