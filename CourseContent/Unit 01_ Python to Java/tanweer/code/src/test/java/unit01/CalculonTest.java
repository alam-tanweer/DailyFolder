package unit01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculonTest {

    @Test
    public void testAdd() {
        // setup
        float x = 5.2f;
        float y = 2.7f;
        float expected = x + y;

        // invoke
        float actual = Calculon.add(x, y);

        // anaylze
        assertEquals(expected, actual, 0.001f);
    }

    @Test
    public void testSubtract() {
        // setup
        float x = 5.2f;
        float y = 2.7f;
        float expected = x - y;

        // invoke
        float actual = Calculon.subtract(x, y);

        // anaylze
        assertEquals(expected, actual, 0.001f);
    }

    @Test
    public void testMultiply() {
        // setup
        float x = 5.2f;
        float y = 2.7f;
        float expected = x * y;

        // invoke
        float actual = Calculon.multiply(x, y);

        // anaylze
        assertEquals(expected, actual, 0.001f);
    }

    @Test
    public void testDivide() {
        // setup
        float x = 5.2f;
        float y = 2.7f;
        float expected = x / y;

        // invoke
        float actual = Calculon.divide(x, y);

        // anaylze
        assertEquals(expected, actual, 0.001f);
    }
}
