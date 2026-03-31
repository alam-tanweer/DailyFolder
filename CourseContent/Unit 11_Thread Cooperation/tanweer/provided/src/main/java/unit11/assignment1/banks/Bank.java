package unit11.assignment1.banks;

import java.util.LinkedList;

/**
 * Class representing the Bank (consumers) in the WallStreet simulation.
 */
public class Bank implements Runnable {
    //The queue of things to be done.
    private final LinkedList<String> queue;
    //The instance of WallStreet that's traded on
    private final WallStreet wallStreet;
    //Bank ID
    private final int id;

    //Constructor
    public Bank(int id, LinkedList<String> queue, WallStreet wallStreet) {
        this.id = id;
        this.queue = queue;
        this.wallStreet = wallStreet;
    }

    /**
     * Run method which reads messages from the consumers and trades on 
     * WallStreet on the Traders behalf.
     */
    @Override
    public void run() {
        while(true) {
            String message = null;
            synchronized(queue) {
                while(queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        // squash
                    }
                }
                message = queue.remove(0);
            }

            String[] messageSplit = message.split(",");
            String stockName = messageSplit[1];
            boolean purchase = messageSplit[2].equals("purchase");

            synchronized(wallStreet){
                if(purchase){
                    wallStreet.buyStock(stockName);
                }else{
                    wallStreet.sellStock(stockName);
                }
            }
            System.out.println("Bank " + id + ": " + message);
        }
    }
}