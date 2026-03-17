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

    @Override
    public int compareTo(Package o) {
        // This is for Part 1 
        // if (this.getPriority().getRank() > o.getPriority().getRank()) { return 1;}
        // if (this.getPriority().getRank() < o.getPriority().getRank()) {return -1;}
        // else {return 0;}
        
        // THIS IS FOR PART 2 
        // if (this.getPriority().getRank() > o.getPriority().getRank()) {
        //     if ((this.getLength() > o.getLength())) {
        //         return 3;
        //     }
        //     if ((this.getLength() < o.getLength())) {
        //         return 2;
        //     } else {
        //         return 1;
        //     }
        // }
        // if (this.getPriority().getRank() < o.getPriority().getRank()) {
        //     if ((this.getLength() > o.getLength())) {
        //         return -1;
        //     }
        //     if ((this.getLength() < o.getLength())) {
        //         return -2;
        //     } else {
        //         return -1;
        //     }
        // } else {
        //     return 0;
        // }
        // THIS IS FOR PART 3 
        if (this.getPriority().getRank() > o.getPriority().getRank()) {
            if ((this.getWeight() < o.getWeight())) {
                return 3;
            }
            if ((this.getWeight() > o.getWeight())) {
                return 2;
            } else {
                return 1;
            }
        }
        if (this.getPriority().getRank() < o.getPriority().getRank()) {
            if ((this.getWeight() < o.getWeight())) {
                return -1;
            }
            if ((this.getWeight() > o.getWeight())) {
                return -2;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
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
}
