package unit11.assignment2.motel;

public class Woolie extends Guest implements Runnable {
    private final BaitsMotel motel;
    private final int days;

    public Woolie(String name, BaitsMotel motel, int days) {
        super(name);
        this.motel = motel;
        this.days = days;
    }

    @Override
    public void run() {
        System.out.println(getName() + " arrives at the motel and gets in line to check in.");
        motel.checkIn(this);
        System.out.println(getName() + " is checked in and goes to sleep.");
        
        int stayed = 0;
        while(!isMurdered() && stayed < days) {
            System.out.println(getName() + " is sleeping peacefully...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
        if(isMurdered()) {
            System.out.println(getName() + " has been slain!");
        } else {
            System.out.println(getName() + " is ready to check out...");
        }
        motel.checkOut(this);
        System.out.println(getName() + " heads back home.");
    }

}
