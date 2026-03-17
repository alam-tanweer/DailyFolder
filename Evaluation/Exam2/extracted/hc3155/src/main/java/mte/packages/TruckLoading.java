package mte.packages;

import java.util.Comparator;

public class TruckLoading implements Comparator<Package>{
    public int compare(Package p1, Package p2){
        return p1.getPriority().getRank() - p2.getPriority().getRank() == 0 ? p1.getLength() - p2.getLength() : p1.getPriority().getRank() - p2.getPriority().getRank();
    }
}
