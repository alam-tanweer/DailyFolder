package mte.packages;

import java.util.ArrayList;
import java.util.Iterator;

public class PackageIterator implements Iterator<Package> {
    private int index;
    private int size;
    private ArrayList<Package> storage;
    private PackageCollection collection;

    public PackageIterator(PackageCollection collection) {
        this.index = 0;
        this.collection = collection;
        this.size = collection.getSize();
        this.storage = collection.getPackList();
    }
    
    @Override
    public boolean hasNext() {
        return (this.index < this.size);
    }

    @Override
    public Package next() {
        if (hasNext()) {
            Package next = storage.get(index);
            index++;
            return next;
        }
        else { return null; }
    }
}
