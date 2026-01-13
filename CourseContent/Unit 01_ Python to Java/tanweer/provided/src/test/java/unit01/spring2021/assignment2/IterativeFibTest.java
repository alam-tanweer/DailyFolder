package unit01.spring2021.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit01.spring2022.assignment2.IterativeFib;

public class IterativeFibTest {
    @Test
    public void fib0() {
        // setup
        int n = 0;
        int expected = -1;

        // invoke
        int actual = IterativeFib.fib(n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void fib1() {
        // setup
        int n = 1;
        int expected = 0;

        // invoke
        int actual = IterativeFib.fib(n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void fib2() {
        // setup
        int n = 2;
        int expected = 1;

        // invoke
        int actual = IterativeFib.fib(n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void fib3() {
        // setup
        int n = 3;
        int expected = 1;

        // invoke
        int actual = IterativeFib.fib(n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void fib4() {
        // setup
        int n = 4;
        int expected = 2;

        // invoke
        int actual = IterativeFib.fib(n);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void fib10() {
        // setup
        int n = 10;
        int expected = 34;

        // invoke
        int actual = IterativeFib.fib(n);

        // analyze
        assertEquals(expected, actual);
    }
}
