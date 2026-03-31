package unit11;

public class HelloThreadv1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello, world!");
    }

    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            HelloThreadv1 hello = new HelloThreadv1();
            Thread thread = new Thread(hello);
            thread.start();
        }
    }
    
}
