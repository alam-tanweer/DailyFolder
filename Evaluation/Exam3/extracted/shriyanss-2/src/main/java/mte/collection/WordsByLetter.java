package mte.collection;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordsByLetter {

    private Map<String, Set<String>> words;

    public WordsByLetter(String phrase) {
        this.words = new TreeMap<>();

        // iterate over all the words
        for (String word : phrase.split(" ")) {
            String wordLower = word.toLowerCase();

            // get the first alphabet
            String first = wordLower.split("")[0];

            if (words.containsKey(first)) {
                words.get(first).add(wordLower);
            } else {
                Set<String> toInsert = new TreeSet<>();
                toInsert.add(wordLower);
                words.put(first, toInsert);
            }
        }
    }

    public Set<String> getWords(char letter) {
        // convert char to String
        String letterString = String.valueOf(letter).toLowerCase();

        return words.get(letterString);
    }

    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
        System.out.println(wordsByLetters.getWords('t')); // Output: [the]
        System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
