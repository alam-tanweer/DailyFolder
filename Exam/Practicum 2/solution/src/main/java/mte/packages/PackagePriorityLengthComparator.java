package practicum02.packages;

import java.util.Comparator;

public class PackagePriorityLengthComparator implements Comparator<Package> {

    @Override
    public int compare(Package o1, Package o2) {
        int result = o1.getPriority().getRank() - o2.getPriority().getRank();
        return (result != 0) ? result : (o1.getLength() - o2.getLength());
    }

}
