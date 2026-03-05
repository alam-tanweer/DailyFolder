package unit08.practicum.cars;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

public class Cars {
    public static Collection<Car> getCars(String filename, int maxMileage, 
        String color) throws IOException {
        File file = new File(filename);
        return Files.lines(file.toPath())
            .map(Car::makeCar)
            .filter(c -> c.getOdometer() < maxMileage)
            .filter(c -> c.getColor().equals(color))
            .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        getCars("data/cars_100.txt", 150000, "red").forEach(System.out::println);
    }
}
