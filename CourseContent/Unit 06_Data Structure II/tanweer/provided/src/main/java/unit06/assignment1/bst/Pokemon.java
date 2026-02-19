package unit06.assignment1.bst;

public class Pokemon implements Comparable <Pokemon>{
    private int number;
    private String name;

    public Pokemon (int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString () {
        return number + ": " + name;
    }

    @Override
    public int compareTo (Pokemon other) {
        return number - other.number;
    }

    public String getName () {
        return name;
    }

    public static void main(String[] args) {
        BinarySearchTree <Pokemon> pokedex = new BinarySearchTree <>(new Pokemon (130,"gyrados"));
        pokedex.insert (new Pokemon (4,"charmander"));
        pokedex.insert (new Pokemon (7,"squirtle"));
        pokedex.insert (new Pokemon (129,"magicarp"));
        pokedex.insert (new Pokemon (26,"raichu"));

        System.out.println (pokedex);

    }
}
