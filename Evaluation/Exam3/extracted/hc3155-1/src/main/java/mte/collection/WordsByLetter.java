package mte.collection;

import java.util.HashMap;
import java.util.HashSet;


public class WordsByLetter {
    private HashMap<Character, HashSet<String>> map;
    public WordsByLetter(String phrase) {
        map = new HashMap<>();
        for(String word : phrase.toLowerCase().split(" ")){
            if(map.get(word.charAt(0)) == null){
                HashSet<String> ns = new HashSet<>();
                ns.add(word);
            
                map.put(word.charAt(0),ns);
            }
            else{
                map.get(word.charAt(0)).add(word);
            }
        }
    }

    public HashSet<String> getWords(char letter){
        return map.get(letter);
    }

    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
        System.out.println(wordsByLetters.getWords('t')); // Output: [the]
        System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
