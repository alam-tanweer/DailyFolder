package unit03.assignment2.toys;

import java.util.Random;

public class RobotFactory implements Factory {
    private static final Random RNG = new Random(1);

    private static final String[] SOUNDS = {
        "Bleep! Bloop!",
        "Bzzzzzt!",
        "Take me to your leader!",
        "EXTERMINATE THE DOCTOR!"
    };

    private static final int MIN_PRICE = 30;
    private static final int MAX_PRICE = 100;

    @Override
    public Product manufacture() {
        int bound = MAX_PRICE - MIN_PRICE + 1;
        double msrp = RNG.nextInt(bound) + MIN_PRICE - 0.01;
        String sound = SOUNDS[RNG.nextInt(SOUNDS.length)];
        return new Robot(msrp, sound);
    }
    
}
