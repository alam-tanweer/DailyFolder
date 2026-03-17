package mte.packages;

import java.util.ArrayList;
import java.util.Iterator;

public class PackageCollection implements Iterable<Package> 
{
    private int size;

    private ArrayList<Package> internalStorage; 

    public PackageCollection() {
        internalStorage = new ArrayList<>();
    }

    public void addPackage(Package pkg) {
        internalStorage.add(pkg);
        size++;
    }

    public boolean removePackage(Package pkg) {
        size--;
        return internalStorage.remove(pkg);
    }

    public ArrayList<Package> getPackList() { return this.internalStorage; }

    public int getSize() { return this.size; }

    @Override
    public Iterator<Package> iterator() {
        return new PackageIterator(this);
    }
}