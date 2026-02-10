package practicum01;

public class VehicleDemo {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("Civic", 360, 10),       // 36
                new Truck("F150", 22, 1500),     // 20.5
                new Van("Transit", 25, 6),       // 22
                new Car("Corolla", 340, 10),     // 34
                new Van("Odyssey", 28, 4)        // 26
        };

        double total = 0;
        Vehicle best = vehicles[0];

        for (Vehicle v : vehicles) {
            System.out.println(v);

            double eff = v.getFuelEfficiency();
            total += eff;

            if (eff > best.getFuelEfficiency()) {
                best = v;
            }
        }

        System.out.println("\nTotal efficiency = "
                + String.format("%.2f", total));

        System.out.println("Best vehicle = " + best);
    }
}

