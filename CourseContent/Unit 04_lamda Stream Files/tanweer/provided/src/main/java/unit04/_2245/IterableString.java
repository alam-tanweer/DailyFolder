package unit04._2245;
import java.util.Iterator;

public class IterableString implements Iterable<String>{
    private String s;
    
    public IterableString(String s) {
        this.s = s;
    }

	@Override
    public Iterator<String> iterator() {
        return new StringIterator(s);
    }

    public static void main(String[] args) {
        IterableString string = new IterableString("Hello, this is a test. Bye!");
        for (String word : string) {
            System.out.println(word);
        }
    }
}