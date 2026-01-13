package unit01.spring2021.assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit01.spring2022.assignment1.Log;

public class LogTest {
    @Test
    public void testLog2_1() {
        // setup
        int base = 2;
        int n = 1;
        int expected = 0;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLog2_2() {
        // setup
        int base = 2;
        int n = 2;
        int expected = 1;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLog2_10() {
        // setup
        int base = 2;
        int n = 10;
        int expected = 3;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLog2_97() {
        // setup
        int base = 2;
        int n = 97;
        int expected = 6;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLog2_1000000() {
        // setup
        int base = 2;
        int n = 1000000;
        int expected = 19;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLog10_9() {
        // setup
        int base = 10;
        int n = 100;
        int expected = 2;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLog10_100() {
        // setup
        int base = 10;
        int n = 100;
        int expected = 2;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLog10_210() {
        // setup
        int base = 10;
        int n = 210;
        int expected = 2;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLog10_1000001() {
        // setup
        int base = 10;
        int n = 1000001;
        int expected = 6;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testLogNegativeValue() {
        // setup
        int base = 10;
        int n = -100;
        int expected = -1;

        // invoke
        int actual = Log.log(base, n);

        // analyze
        assertEquals(expected, actual);
    }
}
