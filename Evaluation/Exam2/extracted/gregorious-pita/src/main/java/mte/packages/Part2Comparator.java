package mte.packages;

import java.util.Comparator;

public class Part2Comparator implements Comparator<Package>{

    @Override
    public int compare(Package pack1, Package pack2) {
        int rank1 = pack1.getPriority().getRank();
        int rank2 = pack2.getPriority().getRank();
        int priorityCompare = (rank1 - rank2);
        if (priorityCompare != 0) { return priorityCompare; }
        else {
            int length1 = pack1.getLength();
            int length2 = pack2.getLength();
            return (length1 - length2);
        }
    }
}
