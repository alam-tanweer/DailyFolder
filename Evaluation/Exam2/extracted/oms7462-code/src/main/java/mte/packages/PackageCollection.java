package mte.packages;
import java.util.*;
import java.util.ArrayList;

public class PackageCollection implements Iterable<Package> 
{
    private ArrayList<Package> internalStorage; 
    private int size;
    
    public int getSize() {
        return size;
    }

    public PackageCollection() {
        internalStorage = new ArrayList<>();
        size = 0;
        
    }

    public void addPackage(Package pkg) {
        internalStorage.add(pkg);
        size++;
    }

    public boolean removePackage(Package pkg) {
        size--;
        return internalStorage.remove(pkg);  
    }

    @Override 
    public PackageIterator<Package> iterator(){
        return new PackageIterator<>(internalStorage, size);

    }
}