package unit01.activities;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MiscellanyTest {
    @Test
    public void reverseCharsEmpty() {
        // setup
        String string = "";
        String expected = "";

        // invoke
        String actual = Miscellany.reverseChars(string);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void reverseCharsOne() {
        // setup
        String string = "a";
        String expected = "a";

        // invoke
        String actual = Miscellany.reverseChars(string);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void reverseCharsThree() {
        // setup
        String string = "cba";
        String expected = "abc";

        // invoke
        String actual = Miscellany.reverseChars(string);

        // analyze
        assertEquals(expected, actual);
    }

    // @Test
    // public void testPalindromeEmpty() {
    //     // setup
    //     String string = "";
    //     boolean expected = true;

    //     // invoke
    //     boolean actual = Miscellany.isPalindrome(string);

    //     // analyze
    //     assertEquals(expected, actual);
    // }

    // @Test
    // public void testPalindromeOne() {
    //     // setup
    //     String string = "a";
    //     boolean expected = true;

    //     // invoke
    //     boolean actual = Miscellany.isPalindrome(string);

    //     // analyze
    //     assertEquals(expected, actual);
    // }

    // @Test
    // public void testPalindromeTrue() {
    //     // setup
    //     String string = "abcba";
    //     boolean expected = true;

    //     // invoke
    //     boolean actual = Miscellany.isPalindrome(string);

    //     // analyze
    //     assertEquals(expected, actual);
    // }

    // @Test
    // public void testPalindromeFalse() {
    //     // setup
    //     String string = "abab";
    //     boolean expected = false;

    //     // invoke
    //     boolean actual = Miscellany.isPalindrome(string);

    //     // analyze
    //     assertEquals(expected, actual);
    // }

    @Test
    public void testReversal() {
        // setup
        int[] array = {1, 2, 3};
        int[] expected = {3, 2, 1};

        // invoke
        int[] actual = Miscellany.reversal(array);

        // analyze
        assertArrayEquals(expected, actual);
    }
}
