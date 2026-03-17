package mte.packages;

import java.util.Comparator;

public class PackageComparator implements Comparator<Package>{

    public int compare(Package a, Package b){
        if (a.getPriority() == b.getPriority()){
            return b.getWeight() - a.getWeight();
        }
        else{
        return a.getPriority().compareTo(b.getPriority());
        }

    }


}
