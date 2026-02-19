package mte;

public class VehicleDemo {
    public static void main(String[] args){
        Vehicle[] vehicles = new Vehicle[]{new Car("Car 1"), new Truck("Truck1", 500),
                                            new Van("Van1",2), new Car("Car2"), 
                                            new Truck("Truck2",1500), new Van("Van2", 7)};
        for(int i = 0; i < vehicles.length; i++){
            vehicles[i].calculateFuelEfficiency(100, 10);
            System.out.println(vehicles[i]);
        }
        Double bestMPG = vehicles[0].getMPG();
        Vehicle bestVehicle = vehicles[0];
        for(int i = 0; i < vehicles.length;i++){
            if(vehicles[i].getMPG() > bestMPG){
                bestMPG = vehicles[i].getMPG();
                bestVehicle = vehicles[i];
            }
        }
        System.out.println(bestVehicle);
    }
}
