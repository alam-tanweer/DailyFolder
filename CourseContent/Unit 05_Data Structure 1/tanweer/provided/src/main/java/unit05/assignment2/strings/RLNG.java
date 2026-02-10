package unit05.assignment2.strings;

import java.util.Iterator;

public class RLNG implements Iterable<Integer>, Iterator<Integer> {
    private final long a;
    private final long b;
    private static final long MOD = Integer.MAX_VALUE + 1L;
    private int curr;
    private int index;

    public RLNG(int seed) {
        a = 123;
        b = 456789;
        curr = (int) ((a * seed + b) % MOD);
        index = 0;
    }

    public RLNG() {
        this((int) (java.time.LocalDateTime.now().getNano()));
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    @Override
    public Integer next() {
        int temp = curr;
        curr = (int) ((a * curr + b) % MOD);
        index += 1;
        return temp;
    }

    public Integer next(int bound) {
        return next() % bound;
    }

    @Override
    public boolean hasNext() {
        if (index < 1000) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RLNG rng = new RLNG(1);
        System.out.println(rng.next()); // 456912
        System.out.println(rng.next(10)); // 5
        System.out.println(rng.next()); // 526812540
        System.out.println(rng.next(20)); // 9
        System.out.println(rng.next()); // 891741768
        System.out.println(rng.next()); // 163028205

        // for(int random : rng){
        // System.out.println(random);
        // }

        // while(rng.hasNext()){
        // System.out.println(rng.next());
        // }

    }
}
