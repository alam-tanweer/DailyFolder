package mte.packages;
import java.util.Comparator;

public class lengthComparator implements Comparator<Package> {

    @Override
    public int compare(Package o1, Package o2) {
        return o1.compareTo(o2)==0 ? o1.getLength()-o2.getLength() : o1.compareTo(o2);
    }
}
