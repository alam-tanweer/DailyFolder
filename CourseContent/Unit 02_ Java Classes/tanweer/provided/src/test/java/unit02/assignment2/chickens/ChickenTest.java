package unit02.assignment2.chickens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class ChickenTest {
    @Test
    public void createChicken() {
        // setup
        String name = "Clucketta";
        Size size = Size.JUMBO;
        Color color = Color.BROWN;

        // invoke
        Chicken chicken = new Chicken(name, color, size);

        // analyze
        assertEquals(name, chicken.getName());
        assertEquals(color, chicken.getColor());
        assertEquals(size, chicken.getSize());
        assertEquals("Clucketta, a chicken that lays JUMBO BROWN eggs", 
            chicken.toString());
    }

    @Test
    public void testLayEgg() {
        // setup
        Size size = Size.JUMBO;
        Color color = Color.BROWN;
        Chicken chicken = new Chicken("Aleggsander Hamilton", color, size);

        // invoke
        Egg egg = chicken.layEgg();

        // analyze
        assertEquals(size, egg.getSize());
        assertEquals(color, egg.getColor());
        assertFalse(egg.isCracked());
    }
    
}
