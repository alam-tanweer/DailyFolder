package mte;

public class VehicleDemo {

    public static void main(String[] args) {

        // vehicle array 5 size
        Vehicle[] vehicles = new Vehicle[5];

        // store a mixture of three vehicles
        vehicles[0] = new Car("Car 1", 100, 200);
        vehicles[1] = new Car("Car 2", 200, 100);
        vehicles[2] = new Car("Car 3", 100, 200);
        vehicles[3] = new Truck("Truck 1", 1000, 200);
        vehicles[4] = new Van("Van 1", 5, 200);

        // USE A LOOP

        Vehicle maxVehicle = null;
        int maxMileage = 0;

        for (int i = 0; i< vehicles.length; i++) {
            System.out.println(vehicles[i]);
            if (vehicles[i].calculateFuelEfficiency() > maxMileage) {
                maxMileage = vehicles[i].calculateFuelEfficiency();
                maxVehicle = vehicles[i];
            }
        }

        // print the max vehicle
        System.out.println(maxVehicle);
    }
}
