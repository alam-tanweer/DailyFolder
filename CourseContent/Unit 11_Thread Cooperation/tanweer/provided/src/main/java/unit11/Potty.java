package unit11;

public class Potty {

    private int capacity = 100;
    private double messLevel;

    public void use() {
        capacity -= 1;
        messLevel += 0.10;
    }



    public int getCapacity() {
        return capacity;
    }



    public double getMessLevel() {
        return messLevel;
    }
}
