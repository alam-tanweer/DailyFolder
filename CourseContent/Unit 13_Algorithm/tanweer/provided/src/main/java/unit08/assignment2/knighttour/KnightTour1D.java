package unit08.assignment2.knighttour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import unit08.backtracker.Backtracker;
import unit08.backtracker.Configuration;


public class KnightTour1D implements Configuration<KnightTour1D> {

    private static final int[] ROW_DIFFS = {-2, -2,  2,  2, -1, -1,  1,  1};
    private static final int[] COL_DIFFS = {-1,  1, -1,  1, -2,  2, -2,  2};

    private final Chessboard1D board;
    private final int row;
    private final int col;
    private final boolean valid;

    public KnightTour1D(Chessboard1D board, int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;
        // this.valid = board.makeMove(row, col);
        this.valid = true;
    }

    @Override
    public Collection<KnightTour1D> getSuccessors() {
        List<KnightTour1D> successors = new ArrayList<>();
        
        Chessboard1D nextMove = new Chessboard1D(board);
        for(int i=0; i<ROW_DIFFS.length; i++) {
            int nextRow = row + ROW_DIFFS[i];
            int nextCol = col + COL_DIFFS[i];
            if(nextMove.makeMove(nextRow, nextCol)) {
                successors.add(new KnightTour1D(nextMove, nextRow, 
                    nextCol));
                nextMove = new Chessboard1D(board);
            }
        }

        // if(successors.size() == 0) {
        //     System.out.println(board);
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
        Backtracker<KnightTour1D> backtracker = new Backtracker<>(false);
        Chessboard1D board = new Chessboard1D(8);
        board.makeMove(0, 0);
        KnightTour1D config = new KnightTour1D(board, 0, 0);
        KnightTour1D solution = backtracker.solve(config);
        System.out.println(solution);
    }
    
}

