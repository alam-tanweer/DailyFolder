package unit08.assignment.part1;

import java.util.ArrayList;
import java.util.List;

public class Woolie implements Runnable {
    public enum City {
        COURTWALD("Courtwald"),
        GLASSDELL("Glassdell");

        private final String cityName;

        private City(String cityName) {
            this.cityName = cityName;
        }

        @Override
        public String toString() {
            return cityName;
        }
    }

    public static final int SECOND = 1000;

    private String name;
    private int crossingTime;
    private City location;
    private City destination;

    public Woolie(String name, int crossingTime, City location, City destination) {
        this.name = name;
        this.crossingTime = crossingTime;
        this.location = location;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println(name + " has arrived at the bridge at " + 
            location + ".");
        for(int i = 0; i < crossingTime; i++) {
            if(i == 0) {
                System.out.println(name + " is starting to cross.");
            } else if(i == 1) {
                System.out.println("\t" + name + ": " + i + " second.");
            } else {
                System.out.println("\t" + name + ": "  + i + " seconds.");
            } 
            try{
                Thread.sleep(SECOND);
            } catch(InterruptedException ie) {}
        }

        System.out.println(name + " leaves at " + destination + ".");
    }
    
    public static void main(String[] args) {
        List<Woolie> woolies = new ArrayList<>();
        woolies.add(new Woolie("Dilip", 4, City.GLASSDELL, City.COURTWALD));
        woolies.add(new Woolie("Artem", 3, City.COURTWALD, City.GLASSDELL));
        woolies.add(new Woolie("Anya", 5, City.GLASSDELL, City.COURTWALD));
        woolies.add(new Woolie("Marta", 6, City.COURTWALD, City.GLASSDELL));

        for(int i = 0; i < woolies.size(); i++) {
            Thread thread = new Thread(woolies.get(i));
            thread.start();
        }
    }
}
