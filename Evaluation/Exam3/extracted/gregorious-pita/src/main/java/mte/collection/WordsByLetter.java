package mte.collection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class WordsByLetter {
    HashSet<String> uniqueWords = new HashSet<>();


    public WordsByLetter(String phrase) {
        for (String word : phrase.toLowerCase().split(" ")) {
            uniqueWords.add(word);
        }
    }

    public List<String> getWords(char first) {
        List<String> words = new LinkedList<>();

        for (String word : uniqueWords) {
            if (word.charAt(0) == first) {
                words.add(word);
            }
        }

        return words;
    }


    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
         System.out.println(wordsByLetters.getWords('t')); // Output: [the]
         System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
