package unit03.assignment2.toys;

import java.util.Random;

public class Warehouse {
    private static final Random RNG = new Random(1);

    private final Factory[] factories;

    public Warehouse(Factory[] factories) {
        this.factories = factories;
    }

    public void load(Truck truck) {
        while(!truck.isFull()) {
            int index = RNG.nextInt(factories.length);
            Factory factory = factories[index];
            Product product = factory.manufacture();
            truck.load(product);
        }
    }
    
    public static void main(String[] args) {
        Factory[] factories = {
            new RobotFactory()
        };
        Warehouse warehouse = new Warehouse(factories);
        Truck truck = new Truck(10);
        warehouse.load(truck);

        while(!truck.isEmpty()) {
            System.out.println(truck.unload());
        }
    }
}
