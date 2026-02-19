package unit06;

/**
 * A node in a binary tree; each node contains a value and two subtrees.
 * 
 * @author GCCIS Faculty
 */
public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    /**
     * Creates a new binary node with the specified value and subtrees.
     * 
     * @param value The value stored in the node.
     * @param left The left subtree.
     * @param right The right subtree.
     */
    public BinaryNode(int value, BinaryNode left, BinaryNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Creates a new binary node with the specified value and empty subtrees.
     * 
     * @param value The value stored in the node.
     */
    public BinaryNode(int value) {
        this(value, null, null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
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
    public boolean search(int target) {
        if(target == value) {
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
