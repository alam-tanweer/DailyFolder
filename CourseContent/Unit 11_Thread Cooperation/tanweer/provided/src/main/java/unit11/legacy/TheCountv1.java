package unit11.legacy;

public class TheCountv1 implements Runnable {
    private static int[] COUNT = new int[1];

    private final int id;

    public TheCountv1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Counter " + id + " is starting...");
        for(int i=0; i<100000; i++) {
            COUNT[0]++;
        }
        System.out.println("Counter " + id + " is done!");
        // code example for slides
        // int temp = COUNT[0] + 1;
        // COUNT[0] = temp;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<10; i++) {
            TheCountv1 counter = new TheCountv1(i);
            Thread thread = new Thread(counter);
            thread.start();
        }

        Thread.sleep(1000);

        System.out.println(COUNT[0]);
    }
    
}
