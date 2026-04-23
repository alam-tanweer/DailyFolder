package practicum3.rivercrossing;

import java.util.HashSet;
import java.util.Set;

public class River {
    public enum Bank {
        EAST,
        WEST;

        public static Bank getOpposite(Bank bank) {
            return bank == EAST ? WEST : EAST;
        }
    }

    private Set<Cargo> eastBank;
    private Set<Cargo> westBank;
    private Bank farmerBank;

    /**
     * Initializes the locations to the Farmer, Hen, Fox, and Seed on the East
     * shore
     * This should only be called once from the RiverCrossing constructor
     */
    public River() {
        farmerBank = Bank.EAST;
        eastBank = new HashSet<>();
        eastBank.add(Cargo.HEN);
        eastBank.add(Cargo.FOX);
        eastBank.add(Cargo.SEED);
        westBank = new HashSet<>();
    }

    /**
     * Copy constructor to initialize this object with copies of a content of
     * another
     * @param tripLeg - the TripLeg to copy contents of
     */
    public River(River river) {
        this.farmerBank = river.farmerBank;
        this.eastBank = new HashSet<>(river.eastBank);
        this.westBank = new HashSet<>(river.westBank);
    }

    /**
     * Returns what bank the farmer is on
     * @return One of Location's enumerations
     */
    Bank getFarmerBank() {
        return farmerBank;
    }

    /**
     * Returns a set of Cargo located at the given bank
     * @return - the set of cargo, may be empty
     */
    Set<Cargo> getCargo(Bank bank) {
        return (bank == Bank.EAST) ?  eastBank : westBank;
    }

    /**
     * Moves the farmer and cargo to the opposite side of the river
     * @param cargo - the cargo that the farmer is transporing, is null if the
     * farmer is crossing the river alone
     */
    public void cross(Cargo cargo) {
        if (farmerBank == Bank.EAST) {
            if (cargo != null) {
                eastBank.remove(cargo);
                westBank.add(cargo);
            }
            farmerBank = Bank.WEST;
        }
        else {
            if (cargo != null) {
                westBank.remove(cargo);
                eastBank.add(cargo);
            }
            farmerBank = Bank.EAST;
        }
    }

    @Override
    public String toString() {
        if (farmerBank == Bank.EAST)
            return "EAST{Farmer " + eastBank + "} ≈≈ WEST{" + westBank + "}";
        else
            return "EAST{" + eastBank + "} ≈≈ WEST{Farmer " + westBank + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof River) {
            River other = (River)o;
            return this.farmerBank == other.farmerBank &&
                    this.eastBank.equals(other.eastBank) &&
                    this.westBank.equals(other.westBank);
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        return farmerBank.hashCode() * eastBank.hashCode() * westBank.hashCode();
    }
}
