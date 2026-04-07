package mte.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordsByLetter {
    private final Map<Character, Set<String>> wordsByLetter;
    private final String phrase;

    public WordsByLetter(String phrase) {
        this.phrase = phrase;
        this.wordsByLetter = new HashMap<>();

        fillMap ();
    }

    private void fillMap () {
        String[] words = phrase.split(" ");
        for (String word : words) {
            word = word.toLowerCase(); // Convert to lowercase for case-insensitive comparison
            char firstLetter = word.charAt(0);
            if (!wordsByLetter.containsKey(firstLetter)) {
                wordsByLetter.put(firstLetter, new HashSet<>());
            }
            wordsByLetter.get(firstLetter).add(word);   
        }
    }

    public Set<String> getWords (char letter) {
        if (!wordsByLetter.containsKey(letter)) {
            return null;
        }
        return wordsByLetter.get(letter);
    }

    public static void main(String[] args) {
        WordsByLetter wordsByLetterMap = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");
        System.out.println(wordsByLetterMap.getWords('t')); // Output: [The]
        System.out.println(wordsByLetterMap.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
