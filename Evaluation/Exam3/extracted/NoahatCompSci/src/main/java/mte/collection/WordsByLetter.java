package mte.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordsByLetter {
    private Set<String> wordSet;


    public WordsByLetter(String phrase) {
        wordSet = new HashSet<>();
        String[] words = phrase.toLowerCase().split(" ");
        Arrays.stream(words).forEach(word -> wordSet.add(word));
    }

    public String[] getWords(char letter){
        ArrayList<String> words = new ArrayList<>();
        for(String word : this.wordSet){
            if(word.startsWith(""+letter)){
                words.add(word);
            }
        }
        return words.toArray(new String[0]);
        // return words.toArray(String[]);
    }

    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
        System.out.println(wordsByLetters.getWords('t')); // Output: [the]
        System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
