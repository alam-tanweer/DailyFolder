package unit08.practicum.cars;

public class Car {
    public enum Make {
        CHEVY,
        FORD,
        HONDA,
        HYUNDAI,
        NISSAN,
        TOYOTA
    }

    private final Make make;
    private final String color;
    private final int year;
    private final int odometer;
    private final double price;

    public Car(Make make, String color, int year, int odometer, double price) {
        this.make = make;
        this.color = color;
        this.year = year;
        this.odometer = odometer;
        this.price = price;
    }

    // provide? too much?
    public static Car makeCar(String car) {
        String[] parts = car.split(",");
        return new Car(Make.valueOf(parts[0]),
            parts[1],
            Integer.parseInt(parts[2]),
            Integer.parseInt(parts[3]), 
            Double.parseDouble(parts[4]));
    }

    public Make getMake() {
        return make;
    }

    public String getColor() {
        return this.color;
    }

    public int getYear() {
        return year;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "A " + color + " " + year + " " + make + " with " + odometer 
            + " miles for " + String.format("$%.2f", this.price);
    }

    public static void main(String[] args) {
        Car car = makeCar("TOYOTA,gray,2020,28000,4358.7");
        System.out.println(car);
    }
}
