package unit07.sets;

import unit07.trees.NodeBST;

public class TreeSet <E extends Comparable<E>> implements Set<E> {
    
    private NodeBST<E> bst;

    public TreeSet() {
        this.bst = new NodeBST<>();
    }

    @Override
    public boolean add(E element) {
        if (!bst.search(element)) {
            bst.insert(element);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(E element) {
        return bst.search(element);
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException ("Remove not supported.");
    }

    @Override
    public int size() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.size() == 0;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return bst.iterator();
    }
    

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("C");
        set.add("A");
        set.add("B");
        set.add("D");
        set.add("B"); // Duplicate, should not be added

        System.out.println("Set contains \"A\": " + set.contains("A"));
        System.out.println("Set contains \"D\": " + set.contains("E"));
        System.out.println("Set size: " + set.size());

        System.out.print("Set elements: ");
        for (String element : set) {
            System.out.print(element + " ");
        }

        System.out.println();
    }
}
