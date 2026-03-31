package unit11;

public class Slides {

    public class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello, World!");
        }
    }

    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello, World!");
        }
    }
}