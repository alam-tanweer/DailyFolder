package unit11.legacy;

/**
 * The correct solution.
 */
public class TheCountv3 implements Runnable {
    private static int[] COUNT = new int[1];

    private final int id;

    public TheCountv3(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Counter " + id + " is starting...");
        
        for(int i=0; i<100000; i++) {
            synchronized(COUNT) {
                COUNT[0]++;
            }
        }
        System.out.println("Counter " + id + " is done!");
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<10; i++) {
            TheCountv3 counter = new TheCountv3(i+1);
            Thread thread = new Thread(counter);
            thread.start();
        }

        Thread.sleep(1000);

        System.out.println(COUNT[0]);
    }    
}

