package unit01.activities;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class ArrayStuffTest {
    @Test
    public void testMultiplicationTable() {
        // setup
        int rows = 2;
        int columns = 3;
        int[][] expected = {
            {1, 2, 3},
            {2, 4, 6}
        };

        // invoke
        int[][] actual = ArrayStuff.multiplicationTable(rows, columns);

        // analyze
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSquares() {
        // setup
        int n = 6;
        int[] expected = {0, 1, 4, 9, 16, 25};

        // invoke
        int[] actual = ArrayStuff.squares(n);

        // analyze
        assertArrayEquals(expected, actual);
    }
}
