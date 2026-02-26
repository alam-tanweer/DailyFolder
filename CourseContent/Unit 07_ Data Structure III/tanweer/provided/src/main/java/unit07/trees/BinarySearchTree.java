package unit07.trees;

/**
 * The abstract data type for a binary search tree.
 * 
 * @author GCCIS Faculty
 */
public interface BinarySearchTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Inserts a value into the binary tree.
     * 
     * @param value The value to be inserted.
     */
    void insert(E value);

    /**
     * Searches the BST to determine whether or not the specified target value
     * is present in the tree.
     * 
     * @param target The target value.
     * @return True if the target is in the tree, false otherwise.
     */
    boolean search(E target);

    /**
     * Returns the number of elements stored in the tree.
     * 
     * @return The size of the BST.
     */
    int size();
}
