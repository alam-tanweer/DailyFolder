package mte.packages;

public class Package implements Comparable<Package> {

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

    // private int compareWeight(Package o) {
    //     if (this.getWeight() == o.getWeight()) {
    //         return 0;
    //     } else if (this.getWeight() > o.getWeight()) {
    //         return 1;
    //     } else {
    //         return -1;
    //     }
    // }

    // private int compareLength(Package o) {
    //     if (this.getLength() == o.getLength()) {
    //         return 0;
    //     } else if (this.getLength() > o.getLength()) {
    //         return 1;
    //     } else {
    //         return -1;
    //     }
    // }

    private int comparePriority(Package o) {
        if (this.getPriority().getRank() == o.getPriority().getRank()) {
            // return compareLength(o);
            return 0;
        } else if (this.getPriority().getRank() > o.getPriority().getRank()) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public int compareTo(Package o) {
        // sort by priority
        return comparePriority(o);
    }
}
