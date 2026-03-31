package unit11.assignment2.goatcarts;

import java.util.Random;

public class GoatCart implements GoatCartInterface{
    private final int cartNumber;
    private final String racerName;
    private int lap;
    private double time;
    private final Troll troll;

    public GoatCart (int cartNumber, Troll troll) {

        this.troll = troll;
        this.cartNumber = cartNumber;
        this.racerName = Utils.makeGoatName();
        lap = 0;
        time = 0;
    }

    @Override
    public String toString() {
        return cartNumber + ":" + racerName;
    }


    @Override
    public void run() {
        Random random = new Random ();
        try {
            Thread.sleep ((random.nextInt(40) + 10) * 100);
            
        } catch (InterruptedException ie) {}

        troll.registerCart (this);

        synchronized (troll) {
            try {
                troll.wait ();
            }catch (InterruptedException ie) {}
        }

        System.out.println (racerName + " starting race!");
        long start = System.currentTimeMillis();
        long stop = start;
        int quaterLap = 0;
        lap = 1;

        while (lap < 6){
            try {
                Thread.sleep (1000);
            } catch (InterruptedException  ie) {}
            quaterLap++;
            if (quaterLap % 4 == 0) {
                lap++;
            }
            stop = System.currentTimeMillis();
            time = (stop - start) / 1000.0;
            // System.out.println (racerName + ":" + time);
        }
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public int getLap() {
        return lap;
    }

    public String getRacerName() {
        return racerName;
    }

    @Override
    public double getRaceTime() {
        return time;
    }
}
