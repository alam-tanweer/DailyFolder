package unit05.assignment2.ranges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class FibonacciRangeTest {
    @Test
    public void first8() {
        // setup - none

        // invoke
        Range range = new FibonacciRange(8);

        // analyze
        assertEquals(8, range.size());
        assertEquals(0, range.get(0));
        assertEquals(1, range.get(1));
        assertEquals(1, range.get(2));
        assertEquals(2, range.get(3));
        assertEquals(3, range.get(4));
        assertEquals(5, range.get(5));
        assertEquals(8, range.get(6));
        assertEquals(13, range.get(7));
    }

    @Test
    public void indexOutOfRange() {
        // setup
        Range range = new FibonacciRange(4);

        // invoke
        try {
            range.get(5);
            fail("index out of range exception expected");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of range: 5", e.getMessage());
        }
    }
}
