package unit06.assignment1.bst;

public class BinaryNode <T> {
    private T value;
    private BinaryNode <T> left;
    private BinaryNode <T> right;

    public BinaryNode (T value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString () {
        return "BinaryNode {value: " + value + ", left: " + left +
               ", right: " + right + "}";
    }

    public T getValue () {
        return value;
    }

    public void setValue (T value) {
        this.value = value;
    }

    public BinaryNode <T> getLeft () {
        return left;
    }

    public void setLeft (BinaryNode <T> left) {
        this.left = left;
    }

    public BinaryNode <T> getRight () {
        return right;
    }

    public void setRight (BinaryNode <T> right) {
        this.right = right;
    }

    public String infixTraversal () {
        String tree = "";
        if (left != null) {
            tree += left.infixTraversal ();
        }

        tree += value + " ";

        if (right != null) {
            tree += right.infixTraversal ();
        }

        return tree;
    }

    public boolean search (T target) {
        if (value == target) {
            return true;
        }

        if (left != null) {
            if (left.search (target) == true) {
                return true;
            }
        }

        if (right != null) {
            if (right.search (target)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<>(2);
        BinaryNode<Integer> three = new BinaryNode<>(3);
        BinaryNode<Integer> nine = new BinaryNode<>(9);
        BinaryNode<Integer> four = new BinaryNode<>(4);

        BinaryNode<Integer> seven = new BinaryNode<>(7);
        BinaryNode<Integer> one = new BinaryNode<>(1);
        BinaryNode<Integer> six = new BinaryNode<>(6);

        root.setLeft(three);
        root.setRight(seven);

        three.setLeft(nine);
        three.setRight(four);

        seven.setLeft(one);
        seven.setRight(six);

        System.out.println(root.infixTraversal ());
        System.out.println(root.search (6));
        System.out.println(root.search (9));
        System.out.println(root.search (15));
    }
}