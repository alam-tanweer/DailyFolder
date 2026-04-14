package unit08.backtracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TicTacToe 
                  implements Configuration<TicTacToe>{
    @Override
    public Collection<TicTacToe> getSuccessors() {
        List<TicTacToe> successors = new ArrayList<>();

        return successors;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean isGoal() {
        return false;
    }

    public static void main(String[] args) {
        Backtracker<TicTacToe> bt = new Backtracker<>(true);
        TicTacToe config = new TicTacToe();
        TicTacToe sol = bt.solve(config);
        System.out.println(sol);
    }
}
