package unit01.spring2020.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import unit01.spring2021.assignment2.Collatz;
import unit01.spring2021.assignment2.Primes;

public class Pss {
    // PSS 1
    public static void problem1() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while(n >= 0) { // students may use while(true) { ... }
            System.out.print("Enter a number: ");
            n = scanner.nextInt();
            System.out.println(n);
            // students may check to see if n < 0 and break
        }
        scanner.close();
    }

    // PSS 2
    public static class PrimesTest {
        @Test
        public void isPrime55() {
            // setup
            int n = 55;

            // invoke
            boolean actual = Primes.isPrime(n);

            // analyze
            assertFalse(actual);
        }
    }

    // PSS 3
    // n   - Collatz Sequence
    // 0   - empty
    // 1   - 1
    // 2   - 2 1
    // 53  - 53 160 80 40 20 10 5 16 8 4 2 1
    // 44 - 44 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1

    // PSS 4
    public static class CollatzTest {
        @Test
        public void sequence44() {
            // setup
            int n = 44;
            String expected = "44 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1";

            // invoke
            String actual = Collatz.sequence(n);

            // analyze
            assertEquals(expected, actual);
        }
    }
}
