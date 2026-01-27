package unit03.practicum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PokemonTest {
    @Test
    public void createThree() {
        // setup
        String name = "Squirtle";
        PokemonType type = PokemonType.WATER;
        int level = 10;

        // invoke
        Pokemon pokemon = new Pokemon(name, type, level);

        // analyze
        assertEquals(name, pokemon.getName());
        assertEquals(type, pokemon.getType());
        assertEquals(level, pokemon.getLevel());
    }

    @Test
    public void createTwo() {
        // setup
        String name = "Squirtle";
        PokemonType type = PokemonType.WATER;
        int level = 1;

        // invoke
        Pokemon pokemon = new Pokemon(name, type);

        // analyze
        assertEquals(name, pokemon.getName());
        assertEquals(type, pokemon.getType());
        assertEquals(level, pokemon.getLevel());
    }

    @Test
    public void levelUp() {
        // setup
        String name = "Squirtle";
        PokemonType type = PokemonType.WATER;
        int level = 10;
        Pokemon pokemon = new Pokemon(name, type, level);

        // invoke
        pokemon.levelUp();
        

        // analyze
        assertEquals(level+1, pokemon.getLevel());
    }

    @Test
    public void levelUp100() {
        // setup
        String name = "Squirtle";
        PokemonType type = PokemonType.WATER;
        int level = 100;
        Pokemon pokemon = new Pokemon(name, type, level);

        // invoke
        pokemon.levelUp();
        

        // analyze
        assertEquals(level, pokemon.getLevel());
    }

    @Test
    public void toStringTest() {
        // setup
        String name = "Squirtle";
        PokemonType type = PokemonType.WATER;
        int level = 100;
        Pokemon pokemon = new Pokemon(name, type, level);
        String expected = "Pokemon{name=Squirtle, type=WATER, level=100}";

        // invoke
        String actual = pokemon.toString();
        

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void equalsTrue() {
        // setup
        Pokemon one = new Pokemon("one", PokemonType.FIRE, 5);
        Pokemon two = new Pokemon("two", PokemonType.FIRE, 5);
        boolean expected = true;

        // invoke
        boolean actual = one.equals(two);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void equalsFalseLevel() {
        // setup
        Pokemon one = new Pokemon("abc", PokemonType.FIRE, 4);
        Pokemon two = new Pokemon("abc", PokemonType.FIRE, 5);
        boolean expected = false;

        // invoke
        boolean actual = one.equals(two);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void equalsFalseType() {
        // setup
        Pokemon one = new Pokemon("abc", PokemonType.GRASS, 5);
        Pokemon two = new Pokemon("abc", PokemonType.FIRE, 5);
        boolean expected = false;

        // invoke
        boolean actual = one.equals(two);

        // analyze
        assertEquals(expected, actual);
    }

}
