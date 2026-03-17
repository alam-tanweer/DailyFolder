package mte.packages;

import java.util.Comparator;


//Ignore this, I thought I was supposed to make a comparator class. I have since fixed it so I use natural order as instructions say to do.
public class Part1Comparator implements Comparator<Package>{

    @Override
    public int compare(Package pack1, Package pack2) {
        int rank1 = pack1.getPriority().getRank();
        int rank2 = pack2.getPriority().getRank();
        return (rank1 - rank2);
    }
}
