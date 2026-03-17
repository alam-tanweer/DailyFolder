package unit12.practicum;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Timing {
    public static void fillList(String name, List<Integer> list, int numberOfValues) {
        long start = System.nanoTime();

        for(int i=0; i<numberOfValues; i++) {
            list.add(i);
        }

        long elapsed = System.nanoTime() - start;
        System.out.println("Filled " + name + " with " + numberOfValues 
            + " in " + elapsed + " nanoseconds");
    }

    public static void main(String[] args) {
        int numberOfValues = 100000000;
        new Thread(() ->  fillList("ArrayList", new ArrayList<>(), 
            numberOfValues)).start();
        new Thread(() -> fillList("Vector", new Vector<>(), 
            numberOfValues)).start();            
    }
}
