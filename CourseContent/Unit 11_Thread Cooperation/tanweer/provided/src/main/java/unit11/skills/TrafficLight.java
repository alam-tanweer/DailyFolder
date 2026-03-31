package unit11.skills;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLight {
    private static final long TICK = 1000;
    private static final long PAUSE = TICK;
    private static final long GREEN = TICK * 5;
    private static final long YELLOW = TICK * 2;

    private final String description;
    private final Lock lock;
	private final Condition condition;
    private Color color;

    public TrafficLight(String description, Lock lock, Condition condition) {
        this.description = description;
        this.lock = lock;
		this.condition = condition;
        color = Color.RED;
    }

    private void setColor(Color color) {
        System.out.println(this + " changes from " + this.color 
            + " to " + color);
        this.color = color;
    }
	
	public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return description;
    }

    public void light() {
        System.out.println(this + " is " + color);
        while(true) {
			lock.lock();
            try {
                Thread.sleep(PAUSE);
                setColor(Color.GREEN);
                Thread.sleep(GREEN);
                setColor(Color.YELLOW);
                Thread.sleep(YELLOW);
                setColor(Color.RED);
            } 
			catch (InterruptedException e) {
                // squash
            }
			
			try {
				condition.signalAll();
			}
			finally {
				lock.unlock();
			}
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        ExecutorService executor = Executors.newCachedThreadPool();

        TrafficLight nsLight = new TrafficLight("The North/South light", lock, condition);
        executor.submit(nsLight::light);

        TrafficLight ewLight = new TrafficLight("The East/West light", lock, condition);
        executor.submit(ewLight::light);
		
		executor.shutdown();
    }
}