package unit02.assignment2.chickens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EggTest {
    @Test
    public void createEgg() {
        // setup
        Color color = Color.BROWN;
        Size size = Size.SMALL; 

        // invoke
        Egg egg = new Egg(color, size);

        // analyze
        assertEquals(color, egg.getColor());
        assertEquals(size, egg.getSize());
        assertFalse(egg.isCracked());
        assertEquals("An uncracked BROWN SMALL (18oz.) egg", egg.toString());
    }

    @Test
    public void crackEgg() {
        // setup
        Egg egg = new Egg(Color.WHITE, Size.EXTRA_LARGE);

        // invoke
        egg.crack();

        // analyze
        assertTrue(egg.isCracked());
        assertEquals("A cracked WHITE EXTRA_LARGE (27oz.) egg", egg.toString());
    }
    
}
