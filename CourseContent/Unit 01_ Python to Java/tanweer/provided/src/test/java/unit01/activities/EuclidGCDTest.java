package unit01.activities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EuclidGCDTest {
    @Test
    public void gcd100() {
        // setup
        int a = 100;
        int b = 60;
        int expected = 20;

        // invoke
        int actual = EuclidGCD.gcd(a, b);

        // analyze
        assertEquals(expected, actual);

    }
}
