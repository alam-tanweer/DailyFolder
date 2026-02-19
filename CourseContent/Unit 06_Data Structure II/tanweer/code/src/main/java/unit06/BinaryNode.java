package unit06;

public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    /**
     * Creates a new binary node with the specified value and subtrees.
     * 
     * @param value The value stored in the node.
     * @param left  The left subtree.
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

    public static void main(String[] args) {
        //6.1
        // // leaf nodes
        // BinaryNode n9 = new BinaryNode(9);
        // BinaryNode n4 = new BinaryNode(4);
        // BinaryNode n1 = new BinaryNode(1);
        // BinaryNode n6 = new BinaryNode(6);

        // // middle level
        // BinaryNode n3 = new BinaryNode(3, n9, n4);
        // BinaryNode n7 = new BinaryNode(7, n1, n6);

        // // root
        // BinaryNode root = new BinaryNode(2, n3, n7);

        // // print structure
        // System.out.println(root);

        //6.2
        BinaryNode root =
            new BinaryNode(2,
                new BinaryNode(3,
                    new BinaryNode(9),
                    new BinaryNode(4)),
                new BinaryNode(7,
                    new BinaryNode(1),
                    new BinaryNode(6)));

        System.out.println(root.infixTraversal());

        // System.out.println(root.search(21));

    }
}
