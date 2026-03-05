package unit08;

public class RunnableExample implements Runnable {
    private final int id;

    public RunnableExample (int id) {
        this.id = id;
    }

    public void run () {
        System.out.println (id);
    }
    
    public static void main (String[] args) {
        Runnable example = 
            new RunnableExample (1);
        Thread exampleThread = 
            new Thread (example);
        exampleThread.start ();
    }
}

 