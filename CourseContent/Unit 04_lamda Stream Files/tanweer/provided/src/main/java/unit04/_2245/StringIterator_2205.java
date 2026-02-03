package unit04._2245;

import java.util.Iterator;

public class StringIterator_2205 implements Iterator <Character> {
    private String string;
    private int index;

    public StringIterator_2205(String str) {
        string = str;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < string.length ();
    }

    @Override
    public Character next() {
        char character = string.charAt (index);
        index++;
        return character;
    }

    public static Iterable <Character> iterableString (String str) {
        return new Iterable<Character> (){
            @Override
            public Iterator<Character> iterator() {
                return new StringIterator_2205(str);
            }
        };
    }

    public static void main(String[] args) {
        for (Character ch : iterableString ("Hello World!")) {
            System.out.println (ch);
        }
    }
    
}

