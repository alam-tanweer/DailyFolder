package mte.packages;

import java.util.ArrayList;
import java.util.Iterator;

public class PackageCollection implements Iterable<Package> 
{
    private ArrayList<Package> internalStorage; 

    @Override
    public Iterator<Package> iterator() {
        return {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i!= internalStorage.size();
            }

            @Override
            public Package next() {
                i++;
                return internalStorage.get(i-1);
            }
        };
    }

    public PackageCollection() {
        internalStorage = new ArrayList<>();
    }

    public void addPackage(Package pkg) {
        internalStorage.add(pkg);
    }

    public boolean removePackage(Package pkg) {
        return internalStorage.remove(pkg);
    }
}