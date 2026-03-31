package unit11.assignment2.motel;

import java.util.ArrayList;
import java.util.List;

/**
 * "Baits Motel"
 */
public class BaitsMotel {
    private final int rooms;
    private List<Guest> occupants;

    public BaitsMotel(int rooms) {
        this.rooms = rooms;
        this.occupants = new ArrayList<>();
    }

    public synchronized int getOccupancy() {
        return occupants.size();
    }

    public synchronized Guest getOccupant(int roomNumber) {
        return occupants.get(roomNumber);
    }

    public int getRooms() {
        return rooms;
    }

    public synchronized boolean isAtCapacity() {
        return getOccupancy() >= rooms;
    }

    public synchronized void checkIn(Guest guest) {
        while (getOccupancy() >= rooms) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        occupants.add(guest);
    }

    public synchronized void checkOut(Guest guest) {
        occupants.remove(guest);
    }
}
