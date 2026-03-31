package unit11.legacy.practicum;

public class Joiner extends Thread {
    private String name;
    private long sleep;
    private Thread other;

    public Joiner(String name, long sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleep);
            System.out.println(name + " calling join...");
            other.join();
        } catch (InterruptedException e) {
            // squash
        }
    }

    public static void main(String[] args) {
        Joiner one = new Joiner("one", 0);
        Joiner two = new Joiner("two", 5000);

        one.other = two;
        two.other = one;

        one.start();
        two.start();
    }
    
}
