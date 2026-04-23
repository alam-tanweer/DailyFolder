package practicum3.rivercrossing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import practicum3.backtracker.Backtracker;
import practicum3.backtracker.Configuration;

public class RiverCrossing implements Configuration<RiverCrossing>{
    River river;
    /**
     * visited keeps track of TripLegs already seen so that the program does
     * not fall into a cycle.  You do not need to do anything with this set
     * except to pass it as is to the private constructor if called
     */
    private Set<River> visited;
    
    /**
     * Default to an initial configuration of Farmer, Hen, Fox, Seed on East
     * shore
     * This contructor is called once from main
     */
    public RiverCrossing() {
        this(new River(),new HashSet<>());
    }

    /**
     * Creates a new RiverCrossing object with the given tripleg and set of
     * visited triplegs
     * @param river - Current location of the farmer and cargo
     * @param visited - Sset of successor triplegs already visited
     */
    private RiverCrossing(River river,Set<River>visited) {
        this.river = river;
        this.visited = visited;
        this.visited.add(this.river);
    }

    /**
     * Computes the successors for a current configuration
     * @returns a collection of Successors, may be empty if no Successors
     */
    @Override
    public Collection<RiverCrossing> getSuccessors() {
        List<RiverCrossing> successors = new ArrayList<>();

        // Delete from here
        // Farmer crosses alone
        River nextRiver = new River(this.river);
        nextRiver.cross(null);
        if (!visited.contains(nextRiver))
            successors.add(new RiverCrossing(nextRiver,visited));

        for (Cargo cargo : river.getCargo(river.getFarmerBank())) {
            nextRiver = new River(this.river);
            nextRiver.cross(cargo);
            if (!visited.contains(nextRiver))
                successors.add(new RiverCrossing(nextRiver,visited));
        }
        // to here

        return successors;
    }

    /**
     * Determines if the current configuration is valid
     * @return - true if valid, false otherwise
     */
    @Override
    public boolean isValid() {
        boolean valid = false;
        // Delete from here
        River.Bank oppositeBank = River.Bank.getOpposite(river.getFarmerBank());
        Set<Cargo> oppositeCargo = river.getCargo(oppositeBank);

        if (oppositeCargo.contains(Cargo.FOX) && oppositeCargo.contains(Cargo.HEN))
            valid = false;
        else if (oppositeCargo.contains(Cargo.HEN) && oppositeCargo.contains(Cargo.SEED))
            valid = false;
        else
            valid = true;
        // to here

        return valid;
    }

    @Override
    /**
     * Determines if a solution has been reached
     * @return - true if the solution has been reached, false otherwise
     */
    public boolean isGoal() {
        boolean goal = false;
        // Delete from here
        if (river.getFarmerBank() == River.Bank.WEST) {
            Set<Cargo> cargo = river.getCargo(River.Bank.WEST);
            goal = cargo.contains(Cargo.FOX) &&
                    cargo.contains(Cargo.HEN) &&
                    cargo.contains(Cargo.SEED) &&
                    river.getCargo(River.Bank.EAST).isEmpty();
        }
        // to here

        return goal;
    }

    @Override
    public String toString() {
        return river.toString();
    }

    public static void main(String[] args) {
        RiverCrossing riverCrossing = new RiverCrossing();
        Backtracker<RiverCrossing> backtracker = new Backtracker<>(false);
        System.out.println(backtracker.solve(riverCrossing));
    }
}