package mte;

public class Car extends Vehicle{
    String name;
    double fuelEfficiency;

    int milesDriven;
    int gallonsUsed;

    public Car(String name, int milesDriven, int gallonsUsed){
        super(name,(milesDriven/gallonsUsed));
        this.milesDriven = milesDriven;
        this.gallonsUsed = gallonsUsed;
    }

    public double getFuelEfficiency(){
        fuelEfficiency = (double)milesDriven/gallonsUsed;
        return fuelEfficiency;
    }

    public static void main(String[] args) {
        Car car1 = new Car("T", 1, 1);
        Car car2 = new Car("T", 1, 1);
        Car car3 = new Car("T", 1, 2);
        Car car4 = new Car("F", 1, 1);

        System.out.println(car1.toString());

        System.out.println(car1.equals(car2));
        System.out.println(car1.equals(car3));
        System.out.println(car1.equals(car4));
    }
}
