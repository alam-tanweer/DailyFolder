package mte.collection;

import java.util.HashSet;

public class WordsByLetter {
    private HashSet<String> set = new HashSet<>();

    public WordsByLetter(String phrase) {
        for (String word : phrase.split(" ")){
            set.add(word.toLowerCase());
        }
    }

    public HashSet<String> getWords(char letter){
        HashSet<String> set2 = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append(letter);
        for(String word : set){
            if (word.startsWith(sb.toString()));{
                set2.add(word)
            }
        }
        return set2;
    }

    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
        System.out.println(wordsByLetters.getWords('t')); // Output: [the]
        System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
