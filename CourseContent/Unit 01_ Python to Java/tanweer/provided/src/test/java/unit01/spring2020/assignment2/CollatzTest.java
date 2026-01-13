package unit01.spring2020.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit01.spring2021.assignment2.Collatz;


public class CollatzTest {
    @Test
    public void sequenceLessThan1() {
        // setup
        int n = -1;
        String expected = "";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void sequence1() {
        // setup
        int n = 1;
        String expected = "1";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void sequence2() {
        // setup
        int n = 2;
        String expected = "2 1";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void sequence13() {
        // setup
        int n = 13;
        String expected = "13 40 20 10 5 16 8 4 2 1";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze
        assertEquals(expected, actual);
    }
}
