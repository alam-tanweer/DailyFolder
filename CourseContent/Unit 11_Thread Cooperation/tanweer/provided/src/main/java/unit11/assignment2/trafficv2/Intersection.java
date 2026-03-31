package unit11.assignment2.trafficv2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Intersection {
    private final Map<Direction, List<Vehicle>> lines;
    private final Map<Direction, TrafficLight> lights;

    public Intersection() {
        lines = new HashMap<>();
        lines.put(Direction.NORTH, new LinkedList<>());
        lines.put(Direction.NORTH, new LinkedList<>());
        lines.put(Direction.NORTH, new LinkedList<>());
        lines.put(Direction.NORTH, new LinkedList<>());

        lights = new HashMap<>();
        TrafficLight northSouthLight = new TrafficLight("North/South", this);
        Thread northSouthThread = new Thread(northSouthLight);
        northSouthThread.start();
        lights.put(Direction.NORTH, northSouthLight);
        lights.put(Direction.SOUTH, northSouthLight);

        TrafficLight eastWestLight = new TrafficLight("East/West", this);
        Thread eastWestThread = new Thread(eastWestLight);
        eastWestThread.start();
        lights.put(Direction.EAST, eastWestLight);
        lights.put(Direction.WEST, eastWestLight);
    }

    


    
}
