package mte;

public class VehicleDemo {

    public static void main(String[] args) {
        Truck truck2 = new Truck(0, 0);
        Van van = new Van(0, 0);
        Car car = new Car(0);
         Car car2 = new Car(0);

        Vehicle[] array = new Vehicle[5];
        array[1] = truck2;
        array[2]  = van;
        array [3] = car;
        array[4] = car2;
        
    }
    
}
