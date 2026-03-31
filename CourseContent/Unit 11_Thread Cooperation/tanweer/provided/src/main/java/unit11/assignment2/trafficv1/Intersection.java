package unit11.assignment2.trafficv1;

import java.util.HashMap;
import java.util.Map;

import unit11.assignment2.trafficv1.TrafficLight.Color;

public class Intersection {
    private final Map<Direction, TrafficLight> lights;

    public Intersection() {
        TrafficLight northSouth = new TrafficLight("The North/South light", this);
        TrafficLight eastWest = new TrafficLight("The East/West light", this);

        lights = new HashMap<>();
        lights.put(Direction.NORTH, northSouth);
        lights.put(Direction.SOUTH, northSouth);
        lights.put(Direction.EAST, eastWest);
        lights.put(Direction.WEST, eastWest);

        new Thread(northSouth).start();
        new Thread(eastWest).start();
    }

    public void driveThrough(Vehicle vehicle) {
        TrafficLight light = lights.get(vehicle.getDirection());
        synchronized(light) {
            // System.out.println("  " + vehicle 
            //     + " arrives at the intersection.");
            if(light.getColor() != Color.GREEN) {
                System.out.println("  " + vehicle + 
                    " stops because the light is " + 
                    light.getColor() + ".");
                while(light.getColor() != Color.GREEN) {
                    try {
                        light.wait();
                    } catch (InterruptedException e) {
                        // squash
                    }
                }
            }
            System.out.println("  " + vehicle 
                + " drives through the intersection.");
        }
    }
}
