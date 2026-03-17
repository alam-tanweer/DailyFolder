package mte.packages;

import java.util.ArrayList;

public class PackageCollection //implements Iterable<Package> 
{
    private ArrayList<Package> internalStorage; 

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