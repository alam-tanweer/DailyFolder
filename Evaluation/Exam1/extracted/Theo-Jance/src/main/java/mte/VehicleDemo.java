package mte;

public class VehicleDemo {
    public static void main(String[] args) {
        Car car1 = new Car(192, 24);
        Car car2 = new Car(40, 7);
        Truck truck1 = new Truck(300, 53, 56);
        Van van1 = new Van(50, 20, 3);

        Vehicle[] array = {car1, car2, truck1, van1};

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

        System.out.println(truck1);
    }
}
