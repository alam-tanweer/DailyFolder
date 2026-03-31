package unit11.legacy.practicum;

import java.util.Scanner;

public class SequentialCount implements Runnable {
    private final Thread previousThread;
    private final int n;

    public SequentialCount(Thread previousThread, int n) {
        this.previousThread = previousThread;
        this.n = n;
    }

    @Override
    public void run() {
        if(previousThread != null) {
            try {
                previousThread.join();
            } catch (InterruptedException e) {
                // squash
            }
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        Thread previousThread = null;
        for(int n=1; n<=number; n++) {
            SequentialCount sequential = new SequentialCount(previousThread, n);
            previousThread = new Thread(sequential);
            previousThread.start();
        }
        scanner.close();
    }

}
