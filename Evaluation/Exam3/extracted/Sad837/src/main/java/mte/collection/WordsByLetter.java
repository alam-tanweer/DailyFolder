package mte.collection;

import java.util.HashSet;

public class WordsByLetter {
    private HashSet<String> words;
    private String phrase; 


    public WordsByLetter(String phrase) {
        this.phrase =phrase;
        this.words = new HashSet<>();
        String[] split = phrase.split(" ");
        for(String s: split){
            words.add(s.toLowerCase());
        }

    }
public HashSet<String> getWords(char letter){
    HashSet<String> result = new HashSet<>();
    for(String word : words){
        if(word.charAt(0) == Character.toLowerCase(letter)){
            result.add(word);
        }
        
    }
    return result;
    }

    



    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");

        // Uncomment below lines to test.
         System.out.println(wordsByLetters.getWords('t')); // Output: [the]
         System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
