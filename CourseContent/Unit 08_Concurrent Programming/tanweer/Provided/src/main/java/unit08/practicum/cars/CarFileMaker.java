package unit08.practicum.cars;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import unit08.practicum.cars.Car.Make;

public class CarFileMaker {
    private static final int CURRENT_YEAR = 2024;
    private static final Random RNG = new Random(1);
    private static final String[] COLORS = {
        "red", "blue", "gray", "black", "white", "brown", "silver", "tan"
    };

    public static void makeCarFile(String filename, int numberOfCars) 
                                                        throws IOException {
        try(FileWriter fw = new FileWriter(filename);
            PrintWriter writer = new PrintWriter(fw)) {
            Make[] makes = Make.values();
            for(int i=0; i<numberOfCars; i++) {
                Make make = randomChoice(makes);
                String color = randomChoice(COLORS);
                int year = RNG.nextInt(1975, CURRENT_YEAR + 1);
                int odometer = RNG.nextInt(250000);
                double price = getPrice(year, odometer);

                String car = make + "," + color + "," + year + "," + odometer 
                    + "," + price;
                writer.println(car);
            }
        }
    }

    private static <T> T randomChoice(T[] array) {
        return array[RNG.nextInt(array.length)];
    }

    private static double getPrice(int year, int odometer) {
        double msrp = 50000;
        int age = CURRENT_YEAR - year;
        msrp -= 500 * age;
        msrp -= 0.10 * odometer;
        return new BigDecimal(msrp)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
    }

    public static void main(String[] args) throws IOException {
        makeCarFile("data/cars_100.txt", 100);
    }
}
