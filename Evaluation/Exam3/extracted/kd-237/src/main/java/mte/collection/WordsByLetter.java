package mte.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordsByLetter {

    public WordsByLetter(String phrase) {

        Set<String> words = new HashSet<>();

        for (String w : phrase){
            if(w.equals("the"))
            words.add(w.toLowerCase());
        }
    }

    public String getWords(char letter){

        Set<String> character = new HashSet<>();

        for(char chr : letter){
            if(letter.equals("t") ){
                character.add(chr);
                
            }

            if(letter.equals("b") ){
                character.add(chr);
                
            }
        }

    }


    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
         System.out.println(wordsByLetters.getWords('t')); // Output: [the]
         System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
