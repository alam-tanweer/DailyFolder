package mte.packages;

import java.util.Comparator;

public class TruckComparator implements Comparator<Package> {

    @Override 
    public int compare(Package a, Package b){
        int diff = a.getPriority().compareTo(b.getPriority());
        if (diff ==0){
            return a.getLength() - b.getLength();
        }
        else{
            return diff;
        }
    }
    
}
