package unit13;

// Activity 13.1.7
public class Car {
    private String color;
    private double miles;
    private double fuel;
    private String vin;
  
    // Activity 13.1.8
    /**
     * What happens if you try to call the default constructor now?
     *  It will generate an exception because once you write a constructor
     *  you loose the default constructor.
     */
    public Car (String color, double miles, double fuel, String vin) {
        this.color = color;
        this.miles = miles;
        this.fuel = fuel;
        this.vin = vin;
    }

    // Activity 13.1.9
    public void drive(double distance) {
        this.miles += distance;
        double gallons = distance / 30.0;
        fuel -= gallons;
    }
      
    public void refuel(double gallons) {
       fuel += gallons;
    }
    
    // Activity 13.1.10
    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Activity 13.1.11
    @Override
    public String toString() {
        return "Car[vin=" + this.vin +
            ", color=" + this.color + 
            ", miles=" + this.miles +
            ", fuel=" + this.fuel + "]";
    }


    // Activity 13.1.12
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car)obj;
            return this.vin.equals(car.vin);
        } else {
            return false;
        }
    }

    // Activity 13.1.13
    @Override
    public int hashCode() {
        return vin.hashCode();
    }

}
