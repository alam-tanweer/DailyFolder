package unit08.legacy;

public class CounterThread extends Thread {

    private final String name;
 
    public CounterThread (String name) {
       this.name = name;
    }
 
    @Override
    public void run () {
       for (int i = 1; i < 101; i++) {
          System.out.println (name + ":" + i);
       }
    }

   public static void main(String[] args) {
      Thread counter = new CounterThread ("Counter 1");
      counter.start ();

      int count = 0;

      while(counter.isAlive ()) {
         // comment out for busy wait version
         try {
            Thread.sleep(50);
         } catch(InterruptedException e) {}
         count++;
      }



      System.out.println ("Counting finished! Looped " + count + " times.");

      for (char ch = 'A'; ch <= 'Z'; ch++) {
           System.out.print (ch + " ");
      }
      System.out.println ();

        counter.start ();
    }
 }
 
