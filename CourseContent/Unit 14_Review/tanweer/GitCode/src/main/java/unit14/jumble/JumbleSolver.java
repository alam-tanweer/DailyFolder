package unit14.jumble;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import unit14.backtracker.Backtracker;
import unit14.backtracker.Configuration;

public class JumbleSolver implements Configuration<JumbleSolver> {
    private static final Dictionary DICTIONARY = new Dictionary();
    private final List<Character> remainingLetters;
    private final String word;

    public JumbleSolver(String jumble) {
        this.remainingLetters = new ArrayList<>();
        for (char c : jumble.toCharArray())
            remainingLetters.add(c);

        this.word = "";
    }

    private JumbleSolver(String word,List<Character> remainingLetters) {
        this.remainingLetters = remainingLetters;
        this.word = word;
    }

    @Override
    public Collection<JumbleSolver> getSuccessors() {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public boolean isValid() {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public boolean isGoal() {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public String toString() {
        return "Word: " + word + ", Remaining Letters: " + remainingLetters;
    }

    public static void main(String[] args) {
        List<String> jumbles = List.of(
            "zzz",
            "unf", 
            "wlyasa", 
            "rshtea", 
            "blscu",
            "dmersia",
            "seay",
            "eopodl",
            "foobar");

        Backtracker<JumbleSolver> backtracker = new Backtracker<>(false);
        for (String jumble : jumbles){
            JumbleSolver jumbleSolver = new JumbleSolver(jumble); 
            Configuration<JumbleSolver> solution = backtracker.solve(jumbleSolver);
            if(solution == null){
                System.out.println("No solution found for: " + jumble);
            }
            else{
                System.out.println(jumble + " solution: " + solution);
            }    
        }
    } 
}
