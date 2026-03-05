package unit08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample implements Runnable {
    private final int id;

    public ExecutorExample (int id) {
        this.id = id;
    }

    public void run () {
        System.out.println (id);
    }
    
    public static void main (String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            String name = "Task " + i;
            service.submit(()-> System.out.println(name));
        }
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.SECONDS); 
            System.out.println("All tasks completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
