package unit11.skills;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Intersection {
    private final Map<Direction, TrafficLight> lights;
	private final Lock lock;
	private final Condition condition;

    public Intersection(Lock lock, Condition condition) {
		this.lock = lock;
        this.condition = condition;

		ExecutorService executor = Executors.newCachedThreadPool();

        TrafficLight nsLight = new TrafficLight("The North/South light", lock, condition);
        TrafficLight ewLight = new TrafficLight("The East/West light", lock, condition);
        
		lights = new HashMap<>();
        lights.put(Direction.NORTH, nsLight);
        lights.put(Direction.SOUTH, nsLight);
        lights.put(Direction.EAST, ewLight);
        lights.put(Direction.WEST, ewLight);
		
		executor.submit(nsLight::light);
		executor.submit(ewLight::light);
		executor.shutdown();
    }

    public void driveThrough(Vehicle vehicle) {
        TrafficLight light = lights.get(vehicle.getDirection());
		System.out.println("  " + vehicle + " arrives at the intersection.");
        
        if(light.getColor() != Color.GREEN) {
            System.out.println("  " + vehicle + 
                " stops because the light is " + 
                light.getColor() + ".");
			
			lock.lock();
			try {
                while(light.getColor() != Color.GREEN) {
                    condition.awaitUninterruptibly();
                }
			}
		    finally {
                lock.unlock();
            }
		}
        System.out.println("  " + vehicle + " drives through the intersection.");
	}
}