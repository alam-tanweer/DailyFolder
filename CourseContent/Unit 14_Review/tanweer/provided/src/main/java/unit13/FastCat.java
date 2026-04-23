package unit13;

import java.util.HashSet;

public class FastCat <T> implements Concatenator<T> {
    private HashSet<T> set;

    public FastCat() {
      set = new HashSet<>();
    }
    public void add(T t) {
      set.add(t);
    }

    
    public void remove(T t) {
        set.remove(t);
    }
    public String concat() {
        String str = "";
        for(T thing : set) {
            str += thing;
        }
        return str;
    }
}
    
