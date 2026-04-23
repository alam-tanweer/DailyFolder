package unit14.brickle;

import java.util.LinkedList;
import java.util.List;

/**
 * Brickle is RIT's take on the Wordle word-guessing game.
 * <p>
 * The player has up to {@value #MAX_GUESSES} attempts to guess a secret word.
 * After each guess, per-letter feedback is returned as a {@code String} of
 * the same length, where each character indicates:
 * <ul>
 *   <li>{@link #CORRECT} ({@code 'C'}) — right letter, right position (orange)</li>
 *   <li>{@link #PRESENT} ({@code 'P'}) — right letter, wrong position (white)</li>
 *   <li>{@link #ABSENT}  ({@code ' '}) — letter not in the word (black)</li>
 * </ul>
 */
public class Brickle {
    public enum GameState { IN_PROGRESS, WON, LOST }

    public static final char CORRECT = 'C';
    public static final char PRESENT = 'P';
    public static final char ABSENT = ' ';
    private static final int MAX_GUESSES = 6;
    private final String word;
    private int guessesLeft;
    private GameState gameState;

    /**
     * Creates a new Brickle game with the given secret word.
     *
     * @param word the secret word to guess (case-insensitive)
     */
    public Brickle(String word) {
        this.word = word.toUpperCase();
        this.guessesLeft = MAX_GUESSES;
        this.gameState = GameState.IN_PROGRESS;
    }

    /**
     * Returns the number of guesses remaining.
     *
     * @return guesses left
     */
    public int getGuessesLeft() { return guessesLeft; }

    /**
     * Returns the current state of the game.
     *
     * @return {@link GameState#IN_PROGRESS}, {@link GameState#WON}, or {@link GameState#LOST}
     */
    public GameState getGameState() { return gameState; }

    /**
     * Submits a guess and returns per-letter feedback.
     * <p>
     * Duplicate letters are handled correctly: a letter in the guess is only
     * marked {@link #PRESENT} as many times as it appears (unmatched) in the
     * secret word.
     *
     * @param guess the player's guess (case-insensitive)
     * @return a feedback string of the same length as the secret word,
     *         composed of {@link #CORRECT}, {@link #PRESENT}, and {@link #ABSENT}
     * @throws IllegalStateException     if no guesses remain
     * @throws IllegalArgumentException  if the guess length does not match the word length
     */
    public String guess(String guess) {
        guess = guess.toUpperCase();

        if (guessesLeft <= 0) {
            throw new IllegalStateException("No guesses left");
        } else if (guess.length() != word.length()) {
            throw new IllegalArgumentException("Guess must be " + word.length() + " letters");
        }

        guessesLeft--;

        char[] feedback = new char[word.length()];

        List<Character> incorrectLetters = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            if (guess.charAt(i) == word.charAt(i))
                feedback[i] = CORRECT;
            else
                incorrectLetters.add(word.charAt(i));
        }

        if (incorrectLetters.isEmpty()) {
            gameState = GameState.WON;
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (feedback[i] != CORRECT) {
                    int index = incorrectLetters.indexOf(guess.charAt(i));
                    if (index != -1) {
                        feedback[i] = PRESENT;
                        incorrectLetters.remove(index);
                    } else {
                        feedback[i] = ABSENT;
                    }
                }
            }

            if (guessesLeft == 0) {
                gameState = GameState.LOST;
            }
        }

        return new String(feedback);
    }

    /**
     * CLI helper that prints a guess to standard output with ANSI color coding:
     * orange for {@link #CORRECT}, white for {@link #PRESENT},
     * and black for {@link #ABSENT}.
     *
     * @param guess    the original guess string
     * @param feedback the feedback string returned by {@link #guess(String)}
     */
    private static void printFeedback(String guess, String feedback) {
        final String orange = "\u001B[38;5;208m";
        final String white  = "\u001B[97m";
        final String black  = "\u001B[30m";
        final String reset  = "\u001B[0m";
        for (int i = 0; i < guess.length(); i++) {
            if (feedback.charAt(i) == CORRECT)
                System.out.print(orange + guess.charAt(i) + reset);
            else if (feedback.charAt(i) == PRESENT)
                System.out.print(white + guess.charAt(i) + reset);
            else
                System.out.print(black + guess.charAt(i) + reset);
        }
        System.out.println();
    }

    /**
     * Runs an interactive Brickle game on the console.
     * Prompts the player for guesses until the word is found or guesses run out.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Brickle game = new Brickle("APPLE");

        while (game.guessesLeft > 0 && game.gameState == GameState.IN_PROGRESS) {
            System.out.println("You have " + game.guessesLeft + " guesses left.");
            String guess = System.console().readLine("Enter your guess: ");
            String feedback = game.guess(guess);
            printFeedback(guess,feedback);
        }
    }
}
