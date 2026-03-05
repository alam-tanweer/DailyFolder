package unit08.legacy;

public class CollectiveArrayCounter implements Runnable {

    private int[] holder;
    private int number;

    public CollectiveArrayCounter (int[] holder, int number) {
        this.holder = holder;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            holder[0] += 1;
        }            
    }

    public static void main(String[] args)  throws InterruptedException {
        int [] holder = new int [1];
        Thread[] threads = new Thread [100000]; 
        for (int i = 0; i < 100000; i++) {
            threads [i] = new Thread (new CollectiveArrayCounter (holder, 50));
            threads [i].start ();
        }
        for (int i = 0; i <100000; i++) {
            threads[i].join ();
        }

        System.out.println ("Holder has " + holder[0]);
    }
    
}
