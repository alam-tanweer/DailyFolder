package unit08.moonbase.part1;

import java.util.ArrayList;
import java.util.List;

public class Rover implements Runnable {
    public enum Hub {
        HYPERION("Hyperion"),
        ODYSSEY("Odyssey");

        private final String hubName;

        private Hub(String hubName) {
            this.hubName = hubName;
        }

        @Override
        public String toString() {
            return hubName;
        }
    }

    public static final int SECOND = 1000;

    private String name;
    private int transitTime;
    private Hub startHub;
    private Hub endHub;

    public Rover(String name, int transitTime, Hub startHub, Hub endHub) {
        this.name = name;
        this.transitTime = transitTime;
        this.startHub = startHub;
        this.endHub = endHub;
    }

    @Override
    public void run() {
        System.out.println(name + "(" + transitTime + 
            ") is ready to start traversal at the " + startHub + 
            " end of the tunnel.");
        for(int i = 0; i < transitTime; i++) {
            if(i == 0) {
                System.out.println(name + "(" + transitTime + 
                ") is starting traversal.");
            } else if(i == 1) {
                System.out.println("\t" + name + "(" + transitTime +
                "): " + i + " second.");
            } else {
                System.out.println("\t" + name + "(" + transitTime +
                "): " + i + " second.");
            }
            try {
                Thread.sleep(SECOND);
            } catch(InterruptedException ie) {}
        }
        System.out.println(name + "(" + transitTime + 
            ") has completed traversal and has departed at the " + 
            endHub + " end of the tunnel.");
    }

    public static void main(String[] args) {
        List<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover("Orion", 3, Hub.HYPERION, Hub.ODYSSEY));
        rovers.add(new Rover("Nebula", 5, Hub.ODYSSEY, Hub.HYPERION));
        rovers.add(new Rover("Quantum", 4, Hub.HYPERION, Hub.ODYSSEY));
        rovers.add(new Rover("Fusion", 6, Hub.ODYSSEY, Hub.HYPERION));

        for(int i = 0; i < rovers.size(); i++) {
            Thread rover = new Thread(rovers.get(i));
            rover.start();
        }
    }
}
