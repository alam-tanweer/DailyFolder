package unit08.legacy;

import java.util.ArrayList;
import java.util.List;

public class ListAdder implements Runnable {

    private List <Integer> holder;
    private int number;

    public ListAdder (List <Integer> holder, int number) {
        this.holder = holder;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            holder.add (i);
        }            
    }

    public static void main(String[] args)  throws InterruptedException {
        List <Integer> holder = new ArrayList<>();
        Thread[] threads = new Thread [100]; 
        for (int i = 0; i < 100; i++) {
            threads [i] = new Thread (new ListAdder (holder, 50));
            threads [i].start ();
        }
        for (int i = 0; i <100; i++) {
            threads[i].join ();
        }

        System.out.println ("Holder has " + holder.size());
    }
    
}
