package mte.packages;

import java.util.Comparator;

public class PlaneLoading implements Comparator<Package>{
    public int compare(Package p1, Package p2){
        return p1.getPriority().getRank() - p2.getPriority().getRank() == 0 ? p2.getWeight() - p1.getWeight() : p1.getPriority().getRank() - p2.getPriority().getRank();
    }

}
