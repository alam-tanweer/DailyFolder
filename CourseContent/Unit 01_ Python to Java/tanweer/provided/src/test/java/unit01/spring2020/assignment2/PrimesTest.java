package unit01.spring2020.assignment2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit01.spring2021.assignment2.Primes;

public class PrimesTest {
    @Test
    public void isPrimeLessThan1() {
        // setup
        int n = -1;
        
        // invoke
        boolean actual = Primes.isPrime(n);

        // analyze
        assertFalse(actual);
    }

    @Test
    public void isPrime1() {
        // setup
        int n = 1;
        
        // invoke
        boolean actual = Primes.isPrime(n);

        // analyze
        assertFalse(actual);
    }

    @Test
    public void isPrime2() {
        // setup
        int n = 2;
        
        // invoke
        boolean actual = Primes.isPrime(n);

        // analyze
        assertTrue(actual);
    }

    @Test
    public void isPrime13() {
        // setup
        int n = 13;
        
        // invoke
        boolean actual = Primes.isPrime(n);

        // analyze
        assertTrue(actual);
    }

    @Test
    public void isPrime24() {
        // setup
        int n = 24;
        
        // invoke
        boolean actual = Primes.isPrime(n);

        // analyze
        assertFalse(actual);
    }

    @Test
    public void isPrime9() {
        // added this test because 9 is falsely being identified as prime.
        // setup
        int n = 9;
        
        // invoke
        boolean actual = Primes.isPrime(n);

        // analyze
        assertFalse(actual);
    }
}
