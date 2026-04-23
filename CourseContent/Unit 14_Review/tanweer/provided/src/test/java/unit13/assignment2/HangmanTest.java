package unit13.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit13.assignment2.Hangman.Status;

public class HangmanTest {
    @Test
    public void create() {
        // setup 
        String secret = "abc def.";

        // invoke
        Hangman hangman = new Hangman(secret);

        // analyze
        assertEquals(hangman.getWrongGuesses(), 0);
        assertEquals(hangman.revealed(), "--- ---.");
        assertEquals(hangman.getGuesses(), "");
        assertEquals(hangman.getStatus(), Status.IN_PROGRESS);
    }

    @Test
    public void oneWrongGuess() {
        // setup 
        String secret = "abc def.";
        Hangman hangman = new Hangman(secret);

        // invoke
        boolean result = hangman.guess('z');

        // analyze
        assertTrue(result);
        assertEquals(hangman.getWrongGuesses(), 1);
        assertEquals(hangman.revealed(), "--- ---.");
        assertEquals(hangman.getGuesses(), "Z");
        assertEquals(hangman.getStatus(), Status.IN_PROGRESS);
    }

    @Test
    public void oneRightGuess() {
        // setup 
        String secret = "abc def.";
        Hangman hangman = new Hangman(secret);

        // invoke
        boolean result = hangman.guess('d');

        // analyze
        assertTrue(result);
        assertEquals(hangman.getWrongGuesses(), 0);
        assertEquals(hangman.revealed(), "--- d--.");
        assertEquals(hangman.getGuesses(), "D");
        assertEquals(hangman.getStatus(), Status.IN_PROGRESS);
    }

    @Test
    public void oneRightGuessCaseMismatch() {
        // setup 
        String secret = "abc def.";
        Hangman hangman = new Hangman(secret);

        // invoke
        boolean result = hangman.guess('E');

        // analyze
        assertTrue(result);
        assertEquals(hangman.getWrongGuesses(), 0);
        assertEquals(hangman.revealed(), "--- -e-.");
        assertEquals(hangman.getGuesses(), "E");
        assertEquals(hangman.getStatus(), Status.IN_PROGRESS);
    }

    @Test
    public void guessSameTwice() {
        // setup 
        String secret = "abc def.";
        Hangman hangman = new Hangman(secret);
        hangman.guess('d');

        // invoke
        boolean result = hangman.guess('d');

        // analyze
        assertFalse(result);
        assertEquals(hangman.getWrongGuesses(), 0);
        assertEquals(hangman.revealed(), "--- d--.");
        assertEquals(hangman.getGuesses(), "D");
        assertEquals(hangman.getStatus(), Status.IN_PROGRESS);
    }

    @Test
    public void solveFiveMistakes() {
        // setup 
        String secret = "abc def.";
        Hangman hangman = new Hangman(secret);

        // invoke
        hangman.guess('a');
        hangman.guess('b');
        hangman.guess('c');
        hangman.guess('d');
        hangman.guess('E');
        hangman.guess('g');
        hangman.guess('h');
        hangman.guess('i');
        hangman.guess('J');
        hangman.guess('K');
        hangman.guess('F');

        // analyze
        assertEquals(5, hangman.getWrongGuesses());
        assertEquals("abc def.", hangman.revealed());
        assertEquals("A B C D E G H I J K F", hangman.getGuesses());
        assertEquals(Status.WON, hangman.getStatus());
    }

    @Test
    public void failToSolve() {
        // setup 
        String secret = "abc";
        Hangman hangman = new Hangman(secret);

        // invoke
        hangman.guess('a');
        hangman.guess('b');
        hangman.guess('d');
        hangman.guess('E');
        hangman.guess('F');
        hangman.guess('g');
        hangman.guess('h');
        hangman.guess('i');

        // analyze
        assertEquals(6, hangman.getWrongGuesses());
        assertEquals("ab-", hangman.revealed());
        assertEquals("A B D E F G H I", hangman.getGuesses());
        assertEquals(Status.LOST, hangman.getStatus());
    }

    @Test
    public void deepCopy() {
        String secret = "abc def.";
        Hangman hangman = new Hangman(secret);
        hangman.guess('a');
        hangman.guess('b');
        hangman.guess('c');
        hangman.guess('d');
        hangman.guess('g');
        hangman.guess('h');
        hangman.guess('i');
        hangman.guess('J');
        hangman.guess('K');

        // invoke
        Hangman copy = new Hangman(hangman);
        copy.guess('e');
        copy.guess('z');

        // analyze
        assertEquals(5, hangman.getWrongGuesses());
        assertEquals("abc d--.", hangman.revealed());
        assertEquals("A B C D G H I J K", hangman.getGuesses());
        assertEquals(Status.IN_PROGRESS, hangman.getStatus());   
        
        assertEquals(6, copy.getWrongGuesses());
        assertEquals("abc de-.", copy.revealed());
        assertEquals("A B C D G H I J K E Z", copy.getGuesses());
        assertEquals(Status.LOST, copy.getStatus());   
    }
}
