package mte.collection;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class WordsByLetter {
    
    TreeSet<String> words = new TreeSet<>();

    public WordsByLetter(String phrase) {
        createSet(phrase);
    }

    private void createSet(String phrase){
        String[] list = phrase.split(" ");

        for(String word : list){
            words.add(word.toLowerCase());
        }
    }

    public String getWords(char letter){
        List<String> output = new ArrayList<>();

        for(String word : words){
            if(word.charAt(0) == letter){
                output.add(word);
            }
        }

        String response = String.join(", ", output);

        return response;
    }

    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
        System.out.println(wordsByLetters.getWords('t')); // Output: [the]
        System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
