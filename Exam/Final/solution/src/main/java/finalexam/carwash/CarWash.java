package finalexam.carwash;

public class CarWash {
    private int availableBays;

    public CarWash(int bays) {
        this.availableBays = bays;
    }

    public boolean hasBay() {
        return availableBays > 0;
    }

    public void enter(String carId) {
        availableBays--;
    }

    public void exit() {
        availableBays++;
    }
}