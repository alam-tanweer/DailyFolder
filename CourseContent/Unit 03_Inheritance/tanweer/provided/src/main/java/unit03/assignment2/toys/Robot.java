package unit03.assignment2.toys;

public class Robot extends Toy {

    private final String sound;
    private int charge;

    public Robot(double msrp, String sound) {
        super("Robot", msrp);
        this.sound = sound;
        this.charge = 0;
    }

    public void insertBattery() {
        this.charge = 100;
    }

    @Override
    public void play() {
        if(charge > 0) {
            System.out.println("The robot walks in circles and goes "
                + "\"" + sound + "\"");
            charge -= 15;
        } else {
            System.out.println("The robot sits in silence. "
                + "Its batteries are dead.");
        } 
    }
}
