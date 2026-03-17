package mte.packages;

import java.util.ArrayList;
import java.util.Iterator;

public class PackageCollection implements Iterable<Package> 
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

    public Iterator iterator(){
        //Sorry I know this isnt right :(
        for(int i = 0; i < internalStorage.size(); i++){
            internalStorage.stream().forEach(System.out::println);
        }
        return null;

    }
}