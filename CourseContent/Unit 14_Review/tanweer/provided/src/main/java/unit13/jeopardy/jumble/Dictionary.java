package unit13.jeopardy.jumble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    private final static String WORD_FILE = "data/words.txt";
    private final Set<String> words;
    private final Set<String> prefixes;

    public Dictionary() {
        this.words = new HashSet<>();
        this.prefixes = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(WORD_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                this.words.add(line);
                for (int i = 1; i <= line.length(); i++) {
                    this.prefixes.add(line.substring(0, i));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading word file: " + e.getMessage());
        }
    }

    public boolean isWord(String s) {
        return this.words.contains(s);
    }

    public boolean isPrefix(String s) {
        return this.prefixes.contains(s);
    }
}
