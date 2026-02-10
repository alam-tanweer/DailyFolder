package unit05.assignment2.files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class IterableReaderTest {
    @Test
    public void next() {
        try (IterableReader reader = new IterableReader("data/simple.txt");) {
            assertTrue(reader.hasNext());
            String expected = "one";
            String actual = reader.next();
            assertEquals(expected, actual);
        } catch (IOException e) {
            assertFalse(true);
        }
    }
}
