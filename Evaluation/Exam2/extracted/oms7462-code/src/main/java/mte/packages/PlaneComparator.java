package mte.packages;

import java.util.Comparator;

public class PlaneComparator implements Comparator<Package> {
    @Override 
    public int compare(Package a, Package b){
        int diff = a.getPriority().compareTo(b.getPriority());
        if (diff ==0){
            return b.getWeight() - a.getWeight();
        }
        else{
            return diff;
        }
    }
}
