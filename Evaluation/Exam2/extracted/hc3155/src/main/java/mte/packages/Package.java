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
    public String toString() {
        return "[Priority=" + priority + ", length=" + length + ", weight=" + weight + "]";
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Package p){
            return this.priority == p.getPriority() && this.length == p.getLength() && this.weight == p.getWeight();
        }
        return false;
    }
    @Override
    public int compareTo(Package p){
        return this.priority.getRank() - p.getPriority().getRank();
    }
}
