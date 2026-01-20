package unit02.assignment2.roulette;
import java.util.Random;

public class Wheel {
    private static final int FIRST_NUMBER = 0;
    private static final int TOTAL_NUMBERS = 37;
    private static final int SEPERATION = 26;
    private static final int MIN_MOVEMENT = 3 * TOTAL_NUMBERS;
    private static final int RANDOM_MOVEMENT = 5 * TOTAL_NUMBERS;
    
    private int ballLocation;
    private Location[] wheel;


    public Wheel () {
        ballLocation = FIRST_NUMBER;
        int number = FIRST_NUMBER;
        wheel = new Location [TOTAL_NUMBERS];
        wheel [0] = new Location (number, Color.GREEN);
        Color color = Color.RED;
        for (int index = 1; index < TOTAL_NUMBERS; index++) {
            number = (number + SEPERATION) % TOTAL_NUMBERS;
            wheel [index] = new Location (number, color);
            if (color == Color.RED) {
                color = Color.BLACK;
            }
            else {
                color = Color.RED;
            }
        }
    }


    @Override
    public String toString() {
        String wheel = "";
        for (int i = 0; i < TOTAL_NUMBERS; i++) {
            wheel += this.wheel[i]; 
        }
        return wheel;
    }

    public static void main(String[] args) {
       Wheel wheel = new Wheel ();
       System.out.println (wheel); 
    }


    public void spin () {
        Random random = new Random ();
        int moved = random.nextInt (RANDOM_MOVEMENT) + MIN_MOVEMENT;
        ballLocation = (ballLocation + moved) % TOTAL_NUMBERS;
    }

    public Location getStoppedOn () {
        return new Location (wheel [ballLocation].getNumber(), 
                             wheel [ballLocation].getColor());
    }
}
