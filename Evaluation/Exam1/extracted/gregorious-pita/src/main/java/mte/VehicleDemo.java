package mte;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] vehicleArray = {
            new Car("Car1", 20, 2),
            new Car("Car2", 50, 7),
            new Truck("Truck1", 12, 500),
            new Truck("Truck2", 12, 2000),
            new Van("Van1", 8, 3),
            new Van("Van2", 9, 4)
        };

        int mpg_king_index = -1;
        double mpg_king_mpg = -1;
        for (int i = 0; i < vehicleArray.length; i++) {
            System.out.println(vehicleArray[i]);
            if (vehicleArray[i].mpg > mpg_king_mpg) {
                mpg_king_index = i;
                mpg_king_mpg = vehicleArray[i].mpg;
            }
        }
        System.out.println("Highest efficiency vehicle is:  " + vehicleArray[mpg_king_index]);
    }
}
