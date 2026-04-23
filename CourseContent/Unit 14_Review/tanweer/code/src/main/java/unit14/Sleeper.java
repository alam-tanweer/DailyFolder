package unit14;

import java.util.Random;

public class Sleeper implements Runnable {
    private int sleepTime;

    public Sleeper(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println("I'm feeling sleepy...");
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Ah, that's better!");
    }

    public static void main(String[] args) {
        Random rng = new Random();
        for (int i = 0;i < 5;++i) {
            int sleepTime = rng.nextInt(1,11);
            new Thread(new Sleeper(sleepTime)).start();
        }
    }
}
