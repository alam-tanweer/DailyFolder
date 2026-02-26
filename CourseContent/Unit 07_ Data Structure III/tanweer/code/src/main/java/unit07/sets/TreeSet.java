package unit07.sets;

import java.util.Iterator;

import unit07.trees.NodeBST;

public class TreeSet<E extends Comparable<E>> implements Set<E>, Iterable<E> {
    private NodeBST<E> bst;

    public TreeSet() {
        this.bst = new NodeBST<>();
    }

    @Override
    public boolean add(E element) {
        if(!contains(element)){
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int size() {
        return this.bst.size();
    }

    @Override
    public boolean isEmpty() {
        return this.bst.size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return this.bst.iterator();
    }

    @Override
    public String toString(){
        return this.bst.toString();
    }

    public static void main(String[] args) {
        TreeSet<String> data = new TreeSet<>();
        data.add("A");
        data.add("C");
        data.add("A"); // Duplicate
        data.add("B");

        System.out.println(data.toString());
        System.out.println(data.size());

        // 7.4
        for(String value : data){
            System.out.println(value);
        }
    }


}
