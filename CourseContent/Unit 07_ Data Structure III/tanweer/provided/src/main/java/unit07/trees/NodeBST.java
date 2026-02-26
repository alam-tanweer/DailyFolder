package unit07.trees;

import java.util.Iterator;

/**
 * A simple node-based Binary Search Tree (BST) implementation.
 *
 * Elements are stored in BinaryNode instances. Ordering is determined by
 * the natural ordering of E (E must implement Comparable<E>). Duplicate
 * values are placed in the right subtree (compareTo >= 0 behavior).
 *
 * This class provides insertion, search, size reporting, an in-order
 * traversal string representation, and an in-order Iterator.
 *
 * @param <E> the type of elements maintained by this tree; must be Comparable
 */
public class NodeBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    
    /**
     * Root node of the binary search tree. Null when the tree is empty.
     */
    private BinaryNode<E> root;

    /**
     * Number of elements stored in the tree.
     */
    private int size;

    /**
     * Construct an empty NodeBST.
     */
    public NodeBST() {
        this.root = null;
        this.size = 0;
    }


    /**
    * Insert a value into the BST. Duplicates are placed in the right subtree
    * (consistent with compareTo >= 0 branch).
    * @param value the value to insert
    */
    @Override
    public void insert(E value) {
        if(root == null) {
            root = new BinaryNode<>(value);
        } else {
            binaryInsert(root, value);
        }
        size += 1;
    }


    /**
     * Search for a target value in the BST.
     * @param target value to search for
     * @return true if present, false otherwise
     */
    @Override
    public boolean search(E target) {
        return this.root == null ? false : binarySearch(root, target);
    }


    /**
     * Return number of elements stored in the tree.
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Return an infix (in-order) traversal representation of the tree.
     */
    @Override
    public String toString() {
        return root != null ? root.infixTraversal() : "<empty>";
    }

    /**
     * Recursive helper to insert a value starting at the given node.
     */
    private void binaryInsert(BinaryNode<E> node, E value) {
        if(value.compareTo(node.getValue()) < 0) {
            BinaryNode<E> left = node.getLeft();
            if(left != null) {
                binaryInsert(left, value);
            } else {
                left = new BinaryNode<>(value);
                node.setLeft(left);
            }
        } else {
            BinaryNode<E> right = node.getRight();
            if(right != null) {
                binaryInsert(right, value);
            } else {
                right = new BinaryNode<>(value);
                node.setRight(right);
            }
        }
    }

    /**
     * Recursive helper to search for a value starting at the given node.
     */
    private boolean binarySearch(BinaryNode<E> node, E target) {
        if(target.equals(node.getValue())) {
            return true;
        } else if(target.compareTo(node.getValue()) < 0) {
            BinaryNode<E> left = node.getLeft();
            return left != null && binarySearch(left, target);
        } else {
            BinaryNode<E> right = node.getRight();
            return right != null && binarySearch(right, target);
        }
    }

    /**
     * Return an in-order iterator over the tree's values.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private java.util.Stack<BinaryNode<E>> stack = new java.util.Stack<>();
            private BinaryNode<E> current = root;

            @Override
            public boolean hasNext() {
                return !stack.isEmpty() || current != null;
            }

            @Override
            public E next() {
                while (current != null) {
                    stack.push(current);
                    current = current.getLeft();
                }
                BinaryNode<E> node = stack.pop();
                E value = node.getValue();
                current = node.getRight();
                return value;
            }
        };
    }
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new NodeBST<>();
        System.out.println(bst);

        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);

        System.out.println(bst);

        System.out.println(3 + ": " + bst.search(3));
        System.out.println(7 + ": " + bst.search(7));
        System.out.println(9 + ": " + bst.search(9));
        System.out.println(17 + ": " + bst.search(17));

        for (Integer value : bst) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
