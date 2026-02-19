package unit06.assignment1.generic_bst;

public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E value);
    boolean search(E value);
    int size();
}
