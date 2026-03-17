package mte.packages;

import java.util.Comparator;

public class Part3Comparator implements Comparator<Package>{

    @Override
    public int compare(Package pack1, Package pack2) {
        int rank1 = pack1.getPriority().getRank();
        int rank2 = pack2.getPriority().getRank();
        int priorityCompare = (rank1 - rank2);
        if (priorityCompare != 0) { return priorityCompare; }
        else {
            int weight1 = pack1.getWeight();
            int weight2 = pack2.getWeight();
            return (weight2 - weight1);
        }
    }
}
