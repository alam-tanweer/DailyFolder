package practicum02.packages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PackageCollection implements Iterable<Package> {

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

    @Override
    public Iterator<Package> iterator() {
        return new PackageIterator();
    }

    /**
     * Inner class implementing the custom Iterator.
     * Iterates in the order of insertion (or any order you choose).
     */
    private class PackageIterator implements Iterator<Package> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < internalStorage.size();
        }

        @Override
        public Package next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more packages to iterate over.");
            }
            return internalStorage.get(currentIndex++);
        }
    }
}