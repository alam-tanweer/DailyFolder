package unit05.assignment2.strings;

import java.util.Iterator;

public class StringIterator implements Iterator<String> {
    private int index;
    private String[] words;

    public StringIterator(String string) {
        this.index = 0;
        words = string.split(" ");
    }

    public String next() {
        if (index >= words.length) {
            throw new IndexOutOfBoundsException("No more words!");
        }
        int temp = this.index;
        this.index += 1;
        return words[temp];
    }

    public boolean hasNext() {
        return index < words.length;
    }
}