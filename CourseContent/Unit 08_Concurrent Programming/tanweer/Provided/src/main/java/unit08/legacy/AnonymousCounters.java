package unit08.legacy;

import java.util.Scanner;

public class AnonymousCounters {
    private static void counter (String name) {
        int count = 1;
        while (count < 101) {
            System.out.println (name + ":" + count);
            count++;
        } 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
    
        System.out.print ("Enter num counters: ");
        int num = in.nextInt ();
        in.close ();
    
        for (int i = 0; i < num; i++) {
            Thread countThread = null;
            String name = "Counter " + i;
            if (i % 2 == 0) {
                countThread = new Thread (new Runnable () {
                    public void run() {
                        counter (name);
                    }
                });
            }
            else {
                countThread = new Thread (()->counter (name));
            }
            countThread.start (); 
        }
      }    
}
