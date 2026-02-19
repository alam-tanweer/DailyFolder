package mte.midterm;

public class VehicleDemo {
    public static void main(String[] args) {
        Car car1 = new Car(50,20);
        Car car2 = new Car(56,21);
        Truck truck1 = new Truck(100,20);
        Truck truck2 = new Truck(50,22);
        Van van1 = new Van(6,15);
        Vehicle[] vehicles = {car1,car2,truck1,truck2,van1};

        for (int index =0; index < vehicles.length; index++){
            System.out.println(vehicles[index]);
        }

        Vehicle bestMPG = vehicles[0];
        for (int index =0; index < vehicles.length; index++){
            if(vehicles[index].getFuelEfficieny() > bestMPG.getFuelEfficieny()){
                bestMPG = vehicles[index];
            }
        
        }
        System.out.println("Best fuel efficiency: " + bestMPG);


    }
    
}
