package unit08.moonbase.part2;

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
    private Control control;

    public Rover(String name, int transitTime, Hub startHub, Hub endHub,
        Control control) {
        this.name = name;
        this.transitTime = transitTime;
        this.startHub = startHub;
        this.endHub = endHub;
        this.control = control;
    }

    @Override
    public void run() {
        System.out.println(name + "(" + transitTime + 
            ") is ready to start traversal at the " + startHub + 
            " end of the tunnel.");
        while(control.accessTunnel() != true) {
            try {
                Thread.sleep(520);
            } catch(InterruptedException ie) {}
        }
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
        control.leaveTunnel();
    }

    public static void main(String[] args) {
        List<Rover> rovers = new ArrayList<>();
        Control control = new Control();
        rovers.add(new Rover("Orion", 3, Hub.HYPERION, Hub.ODYSSEY, control));
        rovers.add(new Rover("Nebula", 5, Hub.ODYSSEY, Hub.HYPERION, control));
        rovers.add(new Rover("Quantum", 4, Hub.HYPERION, Hub.ODYSSEY, control));
        rovers.add(new Rover("Fusion", 6, Hub.ODYSSEY, Hub.HYPERION, control));

        for(int i = 0; i < rovers.size(); i++) {
            Thread rover = new Thread(rovers.get(i));
            rover.start();
        }
    }
}
