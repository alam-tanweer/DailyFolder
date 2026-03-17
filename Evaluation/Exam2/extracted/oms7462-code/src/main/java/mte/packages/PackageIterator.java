package mte.packages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PackageIterator<Package> implements Iterator<Package> {
    private ArrayList<Package> internalStorage; 
    private int size;

    

    public PackageIterator(ArrayList<Package> internalStorage, int size){
        this.internalStorage = internalStorage;
        this.size = size;
    }

    @Override 
    public boolean hasNext(){
        return (internalStorage.get(size) != null);

    }

    @Override 
    public Package next(){
        if (hasNext()){
        return (internalStorage.get(size));
        }
        else{
            throw new NoSuchElementException("No next element");
        }

    }
    
}
