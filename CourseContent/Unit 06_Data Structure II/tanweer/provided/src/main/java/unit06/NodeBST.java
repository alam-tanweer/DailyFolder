package unit06;

public class NodeBST implements BinarySearchTree {
    private BinaryNode root;
    private int size;

    public NodeBST() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void insert(int value) {
       if(root == null) {
            root = new BinaryNode(value);
       } else {
            binaryInsert(root, value);
       }
       size += 1;
    }

    @Override
    public boolean search(int target) {
        return this.root == null ? false : binarySearch(root, target);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return root != null ? root.infixTraversal() : "<empty>";
    }

    private void binaryInsert(BinaryNode node, int value) {
        if(value < node.getValue()) {
            BinaryNode left = node.getLeft();
            if(left != null) {
                binaryInsert(left, value);
            } else {
                left = new BinaryNode(value);
                node.setLeft(left);
            }
        } else {
            BinaryNode right = node.getRight();
            if(right != null) {
                binaryInsert(right, value);
            } else {
                right = new BinaryNode(value);
                node.setRight(right);
            }
        }
    }

    private boolean binarySearch(BinaryNode node, int target) {
        if(target == node.getValue()) {
            return true;
        } else if(target < node.getValue()) {
            BinaryNode left = node.getLeft();
            return left != null && binarySearch(left, target);
        } else {
            BinaryNode right = node.getRight();
            return right != null && binarySearch(right, target);
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new NodeBST();
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
    }
}
