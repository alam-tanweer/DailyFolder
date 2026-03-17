package mte.packages;

import java.util.Comparator;

public class PackageIteratorforlenght implements Comparator<Package> {

    @Override
    public int compare(Package o1, Package o2) {
     int diff = Integer.compare(o1.getPriority(), o2.getPriority());
     return diff == 0 ? Integer.compare(o1.getLength(),o2.getLength()) : diff;
    }

    
}
