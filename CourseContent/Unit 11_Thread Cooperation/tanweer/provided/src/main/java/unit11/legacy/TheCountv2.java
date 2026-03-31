package unit11.legacy;

/**
 * This class exists to make a point about being surgical when choosing which
 * lines of code to synchronize.
 */
public class TheCountv2 implements Runnable {
    private static int[] COUNT = new int[1];

    private final int id;

    public TheCountv2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized(COUNT) {
            System.out.println("Counter " + id + " is starting...");
            for(int i=0; i<100000; i++) {
                COUNT[0]++;
            }
            System.out.println("Counter " + id + " is done!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<10; i++) {
            TheCountv2 counter = new TheCountv2(i+1);
            Thread thread = new Thread(counter);
            thread.start();
        }

        Thread.sleep(1000);

        System.out.println(COUNT[0]);
    }    
}
