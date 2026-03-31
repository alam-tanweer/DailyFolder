package unit11.legacy.practicum;

public class EvensAndOdds implements Runnable {
    private int current;

    public EvensAndOdds(int current) {
        this.current = current;
    }

    @Override
    public void run() {
        while(current <= 30) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // squash
            }        
            System.out.println(current);
            current+=2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new EvensAndOdds(1)).start();
        Thread.sleep(500);
        new Thread(new EvensAndOdds(2)).start();
    }
    
}
