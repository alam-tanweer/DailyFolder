package mte.collection;

import java.util.*;
import java.util.stream.Stream;

public class WordsByLetter {
    Map<String, String> dict;

    public WordsByLetter(String phrase) {
        String lowerphrase = phrase.toLowerCase();
        String[] arr = lowerphrase.split(" ");
        this.dict = new HashMap<String, String>();
        for (String value : arr) {
            char[] charARR = value.toCharArray();
            String firstchar = "" + charARR[0];
            this.dict.put(firstchar, value);
        }
    }

    public String[] GetWords(char letter) {

    }

 String[] array = new String[]; 
 while(True){       
        
 array.add(this.dict.get(letter))
 }
}

    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
        // System.out.println(wordsByLetters.getWords('t')); // Output: [the]
        // System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
