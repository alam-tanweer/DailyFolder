package mte.packages;

public class PackageIteratorforweight {
     @Override
    public int compare(Package o1, Package o2) {
     int diff = Integer.compare(o1.getPriority(), o2.getPriority());
     return diff == 0 ? Integer.compare(-1*(o1.getWeight(),o2.getWeight())) : diff;
    }
}
