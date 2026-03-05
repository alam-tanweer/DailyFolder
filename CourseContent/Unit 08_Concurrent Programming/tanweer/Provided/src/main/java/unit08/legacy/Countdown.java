package unit08.legacy;

public class Countdown implements Runnable {

    @Override
    public void run() {
        int i = -10;
        String header = "T";
        try {
            while (true) {
                if (i == 0) {
                    System.out.println ("Liftoff");
                    header = "";
                }
                else {
                    System.out.println (header + i);
                }
                Thread.sleep (1000);
                i++;
            }
        } catch (InterruptedException ie) {}
        
    }

    public static void main (String[] args) {
        new Thread (new Countdown()).start ();
    }
    
}
