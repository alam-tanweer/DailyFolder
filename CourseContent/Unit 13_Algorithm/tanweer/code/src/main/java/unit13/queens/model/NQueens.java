package unit13.queens.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import unit13.backtracker.Backtracker;
import unit13.backtracker.Configuration;

public class NQueens implements Configuration<NQueens> {

    private final Queen[] queens;  //Array of queens
    private final int n;   //Number of N in the NQueen problem

    public NQueens(int n) {
        this(n, new Queen[0]);
    }

    public NQueens(int n, Queen[] queens) {
        this.n = n;
        this.queens = queens != null ? queens : new Queen[0];
    }

    public Queen[] getQueens() {
        return queens;
    }

    @Override
    public Collection<NQueens> getSuccessors() {
        //Note: queens array is the 
        List<NQueens> successors = new ArrayList<>();
        int length = queens.length;
        int row = length > 0 ? queens[length-1].getRow() + 1 : 0;

        if(row < n) {
            for(int col=0; col < n; col++){
                /**
                 * Create a copy of existing queens + one empty item
                 * Add the next move to the empty item place
                 * add it to successor
                 */
                Queen[] copy = Arrays.copyOf(queens, length + 1);
                copy[length] = new Queen(row, col);
                successors.add(new NQueens(n,copy));
            }
        }

        return successors;
    }

    @Override
    public boolean isValid() {
        int length = queens.length;
        if(length < 2) {
            return true;
        } else {
            /**
             * Logic
             * Get the last Queeen. 
             * Check if it can attack all the previously added queen if it is true then configuration is not valid
             * otherwise return true.
             */
            Queen last = queens[length - 1];
            for(int i=0; i< length -1 ; i++){
                if (last.canAttack(queens[i])){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public boolean isGoal() {
        return isValid() && queens.length == n;
    }

    public String toString(){
        String[][] board = new String[n][n];

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                board[row][col]="[]";
            }
        }

        for(Queen q : queens) {
            board[q.getRow()][q.getCol()] = "[Q]";
        }        

        StringBuilder builder = new StringBuilder();
        for(String[] row : board) {
            for(String col : row) {
                builder.append(col);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens(4);
        // NQueens queens = new NQueens(4, new Queen[] {new Queen(0, 0)});
        System.out.println(queens);
        System.out.println("valid: " + queens.isValid());
        System.out.println("goal: " + queens.isGoal());

        Collection<NQueens> successors = queens.getSuccessors();
        for(NQueens successor : successors) {
            System.out.println(successor);
        }


        // System.out.println("");
        // Backtracker<NQueens> backtracker = new Backtracker<>(false);
        // NQueens nQueens = new NQueens(8);
        // NQueens solution = backtracker.solve(nQueens);
        // if(solution == null) {
        //     System.out.println("no solution");
        // } else {
        //     System.out.println(solution);
        // }
    }    



}
