package mte.collection;

import java.util.HashSet;

public class WordsByLetter {
    private HashSet<String> set = new HashSet<>();

    public WordsByLetter(String phrase) {
        String[] split = phrase.split(" ");
        for(String word : split){
            set.add(word.toLowerCase());
        }
    }

    public HashSet<String> getWords(char letter){
        String stringLetter = "" + letter;
        HashSet<String> newSet = new HashSet<>();
        set.stream().filter(s -> s.startsWith(stringLetter)).forEach(s -> newSet.add(s));
        return newSet;
    }


    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
        System.out.println(wordsByLetters.getWords('t')); // Output: [the]
        System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
