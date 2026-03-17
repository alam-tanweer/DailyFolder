package mte.packages;

public class Package implements Comparable<Package> 
{
    private final Priority priority;
    private final int length;
    private final int weight;

    public Package(Priority priority, int length, int weight) {
        this.priority = priority;
        this.length = length;
        this.weight = weight;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Package b){
        return this.priority.getRank() - b.priority.getRank();
    }

    @Override
    public String toString() {
        return "[Priority=" + priority + ", length=" + length + ", weight=" + weight + "]";
    }
}
