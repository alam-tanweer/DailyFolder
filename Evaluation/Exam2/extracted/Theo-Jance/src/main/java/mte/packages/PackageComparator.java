package mte.packages;

import java.util.Comparator;

public class PackageComparator implements Comparator<Package> {
    public int compare(Package a, Package b){
        int prio = a.getPriority().getRank() - b.getPriority().getRank();
        if(prio != 0){
            return prio;
        }else{
            return a.getLength() - b.getLength();
        }
    }
}
