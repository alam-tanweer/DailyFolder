package unit06;

public class Pokédex {
    private BinarySearchTree bst;

    public Pokédex() {
        this.bst = new NodeBST();
    }

    public void addPokemon(int number) {
        if (!bst.search(number)) bst.insert(number);
    }

    public boolean containsPokemon(int number) {
        return bst.search(number);
    }

    @Override
    public String toString() {
        return bst.toString();
    }

    public static void main(String[] args) {
        Pokédex pokedex = new Pokédex();
        pokedex.addPokemon(4);
        pokedex.addPokemon(129);
        pokedex.addPokemon(36);
        pokedex.addPokemon(132);
        pokedex.addPokemon(1);
        pokedex.addPokemon(50);
        pokedex.addPokemon(3);
        pokedex.addPokemon(9);
        pokedex.addPokemon(51);
        pokedex.addPokemon(54);
        pokedex.addPokemon(130);
        pokedex.addPokemon(6);
        pokedex.addPokemon(25);
        pokedex.addPokemon(136);
        pokedex.addPokemon(2);

        System.out.println(pokedex);
        System.out.println(130 + ": " + pokedex.containsPokemon(130));
        System.out.println(2 + ": " + pokedex.containsPokemon(2));
        System.out.println(150 + ": " + pokedex.containsPokemon(150));
        System.out.println(75 + ": " + pokedex.containsPokemon(75));
    }
}
