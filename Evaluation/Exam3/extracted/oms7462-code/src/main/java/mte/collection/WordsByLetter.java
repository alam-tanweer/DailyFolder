package mte.collection;

import java.util.HashSet;
import java.util.Set;

public class WordsByLetter {
    private String phrase;
    private Set<String> words;


    public WordsByLetter(String phrase) {
        this.phrase = phrase;
        this.words = storeWords();
        

    }

    public Set<String> storeWords(){
        Set<String> words = new HashSet<>();
        String[] all =  this.phrase.split(" ");
        for (int i = 0; i< all.length; i++){
            String word = all[i].toLowerCase();
            words.add(word);
        }
        return words;
        
        
        
    }

    public Set<String> getWords(char letter){
        Set<String> specialWords = new HashSet<>();
        
    
            for (String word : this.words){
            if(word.charAt(0) == letter){
                specialWords.add(word);
            }
            

            }
            return specialWords;

        }

    


    public static void main(String[] args) {
        WordsByLetter wordsByLetters = new WordsByLetter("The cat in the hat is back with a bright blue bat out in the back");
        wordsByLetters.storeWords();

        // Uncomment below lines to test.
        System.out.println(wordsByLetters.getWords('t')); // Output: [the]
        System.out.println(wordsByLetters.getWords('b')); // Output: ["back", "bright", "blue", "bat"]
    }
}
