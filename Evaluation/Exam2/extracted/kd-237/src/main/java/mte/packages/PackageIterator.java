package mte.packages;

import java.util.ArrayList;

public class PackageIterator implements Iterable<Package> {
    ArrayList<Package> data;
    int index= 0;
    int size = data.length();

    public PackageIterator(ArrayList<Package> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext(){
        return index < size; 
    }

    @Override 
    public Package next(){
        Package temp = (Package) data[index];
        index ++;
        return temp;
    }
}