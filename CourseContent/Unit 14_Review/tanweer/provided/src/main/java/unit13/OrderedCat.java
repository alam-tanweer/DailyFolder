package unit13;

import java.util.TreeSet;

public class OrderedCat <T> implements Concatenator <T> {
    private TreeSet<String> set;
    
    public OrderedCat() {
        set = new TreeSet<>();
    }

    public void add(T t) {
        set.add(t.toString());
    }
    public void remove(T t) {
        set.remove(t.toString());
    }
    
    public String concat() {
        String str = "";
        for(String s : set) {
          str += s;
        }
        return str;
    }
}
    