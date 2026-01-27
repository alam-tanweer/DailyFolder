package unit03.activities;

import java.util.Random;

public class RandomExample {
    private static final Random RNG = new Random();

    public static int random(int min, int max) {
        int upperBound = max - min + 1;

        int number = RNG.nextInt(upperBound);

        return number + min;
    }
}
