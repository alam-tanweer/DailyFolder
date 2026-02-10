package unit05.assignment2.ranges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class IntRangeTest {
    @Test
    public void basic() {
        // setup - none

        // invoke
        Range range = new IntRange(1, 3, 1);

        // analyze
        assertEquals(2, range.size());
        assertEquals(1, range.get(0));
        assertEquals(2, range.get(1));
    }

    @Test
    public void evenlyDivisibleStep() {
        // setup - none

        // invoke
        Range range = new IntRange(2, 10, 2);

        // analyze
        assertEquals(4, range.size());
        assertEquals(2, range.get(0));
        assertEquals(4, range.get(1));
        assertEquals(6, range.get(2));
        assertEquals(8, range.get(3));
    }

    @Test
    public void notEvenlyDivisible() {
        // setup - none

        // invoke
        Range range = new IntRange(1, 11, 3);

        // analyze
        assertEquals(4, range.size());
        assertEquals(1, range.get(0));
        assertEquals(4, range.get(1));
        assertEquals(7, range.get(2));
        assertEquals(10, range.get(3));
    }

    @Test
    public void indexOutOfRange() {
        // setup
        Range range = new IntRange(1, 11, 3);

        // invoke
        try {
            range.get(5);
            fail("index out of range exception expected");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of range: 5", e.getMessage());
        }
    }
}
