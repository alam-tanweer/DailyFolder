package unit11.assignment2.trafficv2;

public class TrafficLight implements Runnable {
    private final String description;
    private final Intersection intersection;

    public TrafficLight(String description, Intersection intersection) {
        this.description = description;
        this.intersection = intersection;
    }

    @Override
    public void run() {
        
    }

    public String getDescription() {
        return description;
    }



    public Intersection getIntersection() {
        return intersection;
    }   
}
