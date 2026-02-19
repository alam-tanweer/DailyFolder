package unit06.assignment1.generic_bst;

public class NodeBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private BinaryNode<E> root;
    private int size;

    public NodeBST() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void insert(E value) {
       if(root == null) {
            root = new BinaryNode<>(value);
       } else {
            binaryInsert(root, value);
       }
       size += 1;
    }

    @Override
    public boolean search(E target) {
        return binarySearch(root, target);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return root != null ? root.infixTraversal() : "<empty>";
    }

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

    private boolean binarySearch(BinaryNode<E> node, E target) {
        if(node == null) {
            return false;
        } else if(target.compareTo(node.getValue()) == 0) {
            return true;
        } else if(target.compareTo(node.getValue()) < 0) {
            BinaryNode<E> left = node.getLeft();
            return binarySearch(left, target);
        } else {
            BinaryNode<E> right = node.getRight();
            return binarySearch(right, target);
        }
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
    }
}
