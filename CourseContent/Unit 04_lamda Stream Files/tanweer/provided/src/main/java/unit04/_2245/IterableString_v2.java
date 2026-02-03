package unit04._2245;
import java.util.Iterator;

public class IterableString_v2 implements Iterable<String>{
    private String s;
    
    public IterableString_v2(String s) {
        this.s = s;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            private String[] words = s.split(" ");

            @Override
            public String next(){
                if (index >= words.length) {
                    throw new IndexOutOfBoundsException("I'm at a loss for words!");
                }
                
                int temp = this.index;
                this.index += 1;
                return words[temp];
            }
        
            @Override
            public boolean hasNext() {
                return index < words.length;
            }
        };
    }

    public static void main(String[] args) {
        IterableString string = new IterableString("Hello, this is a test. Bye!");
        for (String word : string) {
            System.out.println(word);
        }
    }
}