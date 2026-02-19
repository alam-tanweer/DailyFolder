package unit06;

import java.util.Arrays;

public class Pokedex {
    private BinarySearchTree bst;

    public Pokedex(){
        bst = new NodeBST();
    }

    public void addPokemon(int nbr){
        //6.8
        if (!containsPokemon(nbr)) {
            bst.insert(nbr);
        }
    }

    //6.10
    public boolean containsPokemon(int nbr){
        return bst.search(nbr);
    }

    @Override
    public String toString(){
        return bst.toString();
    }

    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();

        // pokedex.addPokemon(4);
        // pokedex.addPokemon(129);
        // pokedex.addPokemon(36);
        // pokedex.addPokemon(132);
        // pokedex.addPokemon(1);
        // pokedex.addPokemon(50);
        // pokedex.addPokemon(3);
        // pokedex.addPokemon(9);
        // pokedex.addPokemon(51);
        // pokedex.addPokemon(54);
        // pokedex.addPokemon(130);
        // pokedex.addPokemon(6);
        // pokedex.addPokemon(25);
        // pokedex.addPokemon(136);
        // pokedex.addPokemon(2);
        Arrays.stream(new int[]{39,4,147,75,129,8,146,020,026,36,132,93,1,145,174,50,196,3,151,19})
            .forEach(item -> pokedex.addPokemon(item));

        System.out.println(pokedex);
        System.out.println(130 + ": " + pokedex.containsPokemon(130));
        System.out.println(2 + ": " + pokedex.containsPokemon(2));
        System.out.println(150 + ": " + pokedex.containsPokemon(150));
        System.out.println(75 + ": " + pokedex.containsPokemon(75));
    }    
}
