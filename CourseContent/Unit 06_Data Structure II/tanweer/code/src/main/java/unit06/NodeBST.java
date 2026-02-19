package unit06;

public class NodeBST implements BinarySearchTree{
    private BinaryNode root;
    private int size;

    public NodeBST() {
        this.root = null;
        this.size = 0;
    }

    //6.7
    public void binaryInsert(BinaryNode node, int value){
        if (value < node.getValue()){
            if (node.getLeft() == null){
                node.setLeft(new BinaryNode(value));
            } else {
                this.binaryInsert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null){
                node.setRight(new BinaryNode(value));
            } else {
                this.binaryInsert(node.getRight(), value);
            }
        }
    }

    //6.9
    public boolean binearySearch(BinaryNode node,int value){

        if (node.getValue() == value){
            return true;
        } else if (value < node.getValue()){
            return node.getLeft() != null && binearySearch(node.getLeft(), value);
        } else {
            return node.getRight() != null && binearySearch(node.getRight(), value);
        }
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
        return root != null && binearySearch(root, target);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        return root != null ? root.infixTraversal() : "<Empty>";
    }

    public static void main(String[] args) {
        NodeBST root = new NodeBST();
        for (int value : new int[]{10,2,1,5,3,40,12}){
            root.insert(value);
        }
        // root.insert(10);
        // root.insert(4);
        // root.insert(5);
        System.out.println(root);
        System.out.println(root.search(5));
    }
}
