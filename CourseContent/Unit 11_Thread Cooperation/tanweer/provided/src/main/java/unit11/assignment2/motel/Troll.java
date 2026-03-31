package unit11.assignment2.motel;

import java.util.Random;

public class Troll implements Runnable {
    private static final Random RNG = new Random(1);

    private final BaitsMotel motel;

    public Troll(BaitsMotel motel) {
        this.motel = motel;
    }

    @Override
    public void run() {
        while(true) {
            long randomSleep = RNG.nextInt(7000);
            try {
                Thread.sleep(randomSleep);
            } catch (InterruptedException e) {}

            synchronized(motel) {
                while(motel.getOccupancy() == 0) {
                    try {
                        motel.wait();
                    } catch (InterruptedException e) {}
                }
                
                int roomNumber = RNG.nextInt(motel.getOccupancy());
                Guest guest = motel.getOccupant(roomNumber);
                guest.murder();
            }
        }
    }
    
}
