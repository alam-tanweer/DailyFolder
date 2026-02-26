package unit07.trees;

/**
 * A node in a binary tree; each node contains a value and two subtrees.
 * 
 * @author GCCIS Faculty
 */
public class BinaryNode <E extends Comparable<E>> {
    private E value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    /**
     * Creates a new binary node with the specified value and subtrees.
     * 
     * @param value The value stored in the node.
     * @param left The left subtree.
     * @param right The right subtree.
     */
    public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Creates a new binary node with the specified value and empty subtrees.
     * 
     * @param value The value stored in the node.
     */
    public BinaryNode(E value) {
        this(value, null, null);
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    } 

    /**
     * Performs an infix traversal on the binary tree beginning with this node.
     * 
     * @return The results of the infix traversal of the binary tree.
     */
    public String infixTraversal() {
        String string = "";
        if(left != null) {
            string += left.infixTraversal();
        }
        string += this.value + " ";
        if(right != null) {
            string += right.infixTraversal();
        }
        return string;
    }

    /**
     * Returns true if the target value is in the binary tree, and false 
     * otherwise.
     * 
     * @param target The value being searched for.
     * @return True if the target is found in the tree, false otherwise.
     */
    public boolean search(E target) {
        if(target.equals(value)) {
            return true;
        } 
        boolean found = false;
        if(left != null) {
            found = left.search(target);
        }
        if(!found && right != null) {
            found = right.search(target);
        }
        return found;
    }

    @Override
    public String toString() {
        return "BinaryNode{value=" + this.value
            + ", left=" + this.left
            + ", right=" + this.right 
            + "}";
    }
}
