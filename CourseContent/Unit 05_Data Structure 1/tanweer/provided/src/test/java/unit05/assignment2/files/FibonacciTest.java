package unit05.assignment2.files;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {
    @Test
    public void Fib() {
        IterableFibonacci fib = new IterableFibonacci(3, 6);
        fib.add();
        assertEquals(3, fib.get(0));
        assertEquals(6, fib.get(1));
        assertEquals(9, fib.get(2));
    }

    @Test
    public void forEachLoop() {
        IterableFibonacci fib = new IterableFibonacci(2, 5);
        fib.add();
        long[] expectedFib = { 2, 5, 7 };
        int i = 0;
        for (long elt : fib) {
            assertEquals(expectedFib[i], elt);
            i++;
        }
    }
}
