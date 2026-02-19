package mte.midterm;

public class VehicleDemo {

    public static void main(String[] args) {
        Vehicle[] noahs_garage = {
        new Car("Lamborghini", 21000, 1000),
        new Truck("Tractor 2.0",134023.2,10000,800),
        new Van("Lamborghini", 35000, 1400, 8),
        new Truck("Mazda", 35000, 4200, 1000),
        new Car("Tractor 2.0", 15000, 700)
        };
        for (Vehicle i : noahs_garage){System.out.println(i);}
        System.out.println();
        System.out.println(noahs_garage[4]);
        System.out.println(noahs_garage[0].equals(noahs_garage[2]));
    }
}
