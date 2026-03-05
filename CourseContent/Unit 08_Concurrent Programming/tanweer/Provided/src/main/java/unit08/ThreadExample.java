package unit08;

public class ThreadExample extends Thread {

    private final int id;

    public ThreadExample (int id) {
        this.id = id;
    }

    @Override
    public void run () {
        System.out.println (id);
    }
    
    public static void main (String[] args) throws InterruptedException { 
        Thread example = new ThreadExample (1);
        example.start ();
    }
}
