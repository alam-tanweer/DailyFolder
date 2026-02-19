package mte;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[5];

        vehicles[0] = new Car("Car1", 5, 10);
        vehicles[1] = new Van("Van1", 3, 4);
        vehicles[2] = new Truck("Truck1", 9, 10000);
        vehicles[3] = new Truck("Truck2", 20, 4000);
        vehicles[4] = new Van("Van2", 1, 2);

        Vehicle highestFuelEff = vehicles[0];

        for(int i = 0; i <= 4; i++){
            System.out.println(vehicles[i].toString());

            if(vehicles[i].getFuelEfficiency() > highestFuelEff.getFuelEfficiency()){
                highestFuelEff = vehicles[i];
            }
        }
        System.out.println("\n" + "Highest Fuel Efficiency:" + "\n" + highestFuelEff.toString());
    }
}
