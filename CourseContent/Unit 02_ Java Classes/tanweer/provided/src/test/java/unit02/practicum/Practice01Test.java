package unit02.practicum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Practice01Test {
    @Test
    public void arrayToStringEmpty() {
        // setup
        int[] array = {};
        String expected = "[]";

        // invoke
        String actual = Practice01.arrayToString(array);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void arrayToStringOne() {
        // setup
        int[] array = {3};
        String expected = "[3]";

        // invoke
        String actual = Practice01.arrayToString(array);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void arrayToStringSeveral() {
        // setup
        int[] array = {1, 2, 5};
        String expected = "[1, 2, 5]";

        // invoke
        String actual = Practice01.arrayToString(array);

        // analyze
        assertEquals(expected, actual);
    }
}
