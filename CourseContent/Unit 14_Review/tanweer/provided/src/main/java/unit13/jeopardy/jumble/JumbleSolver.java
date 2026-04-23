package unit13.jeopardy.jumble;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import unit13.backtracker.Backtracker;
import unit13.backtracker.Configuration;

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
        List<JumbleSolver> successors = new ArrayList<>();

        for (Character c : remainingLetters) {
            List<Character> remainingLettersCopy = new ArrayList<>(remainingLetters);
            remainingLettersCopy.remove(c);
            successors.add(new JumbleSolver(word + c, remainingLettersCopy));
        }

        return successors;
    }

    @Override
    public boolean isValid() {
        return DICTIONARY.isPrefix(word);
    }

    @Override
    public boolean isGoal() {
        return remainingLetters.isEmpty() && DICTIONARY.isWord(word);
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
