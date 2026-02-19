package unit06.assignment1.generic_bst;

public class Pokedex {
    private BinarySearchTree<Pokemon> bst;

    public Pokedex() {
        this.bst = new NodeBST<>();
    }

    public void addPokemon(Pokemon pokemon) {
        bst.insert(pokemon);
    }

    public boolean containsPokemon(Pokemon pokemon) {
        return bst.search(pokemon);
    }

    @Override
    public String toString() {
        return bst.toString();
    }

    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(new Pokemon(4, "Charmander"));
        pokedex.addPokemon(new Pokemon(129, "Magikarp"));
        pokedex.addPokemon(new Pokemon(36, "Clefable"));
        pokedex.addPokemon(new Pokemon(132, "Ditto"));
        pokedex.addPokemon(new Pokemon(1, "Bulbasaur"));
        pokedex.addPokemon(new Pokemon(50, "Diglett"));
        pokedex.addPokemon(new Pokemon(3, "Venusaur"));
        pokedex.addPokemon(new Pokemon(9, "Blastoise"));
        pokedex.addPokemon(new Pokemon(51, "Dugtrio"));
        pokedex.addPokemon(new Pokemon(54, "Psyduck"));
        pokedex.addPokemon(new Pokemon(130, "Gyrados"));
        pokedex.addPokemon(new Pokemon(6, "Charizard"));
        pokedex.addPokemon(new Pokemon(25, "Pikachu"));
        pokedex.addPokemon(new Pokemon(136, "Flareon"));
        pokedex.addPokemon(new Pokemon(2, "Ivysaur"));

        System.out.println(pokedex);
        System.out.println(130 + ": " + pokedex.containsPokemon(new Pokemon(130, "")));
        System.out.println(2 + ": " + pokedex.containsPokemon(new Pokemon(2, "")));
        System.out.println(150 + ": " + pokedex.containsPokemon(new Pokemon(150, "")));
        System.out.println(75 + ": " + pokedex.containsPokemon(new Pokemon(75, "")));
    }
}
