package mte.packages;
import java.util.Comparator;

public class weightComparator implements Comparator<Package> {

    @Override
    public int compare(Package o1, Package o2) {
        return o1.compareTo(o2)==0 ? o2.getWeight()-o1.getWeight() : o1.compareTo(o2);
    }
}
