package mte;

public class VehicleDemo {

    public static void main(String[] args) {
        Van v1 = new Van("van1", 200, 100, 8);
        Car c1 = new Car("car1", 300, 12);
        Truck t1 = new Truck("truck1", 500, 50, 2000);
        Car c2 = new Car("car2", 150, 10);
        Truck t2 = new Truck("truck2", 700, 80, 3000);

        Vehicle[] arr = {c1, c2, v1, t1, t2};
        int efficiency = 0;
        int index = 0;

        for (int i = 0; i < arr.length; i ++){
            System.out.println(arr[i]);
            if (arr[i].fuelEfficieny() >= efficiency){
                efficiency = arr[i].fuelEfficieny();
                index = i;
            }
        }
        System.out.println("Vehicle with most efficiency is : " +arr[index]);

    }

}
