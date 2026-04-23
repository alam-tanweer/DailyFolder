package unit13.assignment1.bst;

import unit13.graphs.AdjacencyGraph;
import unit13.graphs.Graph;

public class BstAsGraph {

    public static BinaryNode makeBST (int[] array) {
        BinaryNode bst = null;
        if (array.length == 0) {
            return bst;
        }

        bst = new BinaryNode (array[0]);
        for (int index = 1; index < array.length; index++) {
            bst.binaryInsert (array[index]);
        }
        return bst;
    }

    public static Graph<Integer> convertToGraph (BinaryNode bst) {
        Graph <Integer> graph = new AdjacencyGraph<> ();
        if (bst != null) {
            graph.add (bst.getValue ());
        }
        convertToGraphRec (bst, graph);
        return graph;
    }

    private static void convertToGraphRec (BinaryNode bst, Graph<Integer> graph) {
        if (bst == null) {
            return;
        }
        BinaryNode left = bst.getLeft();
        BinaryNode right = bst.getRight();
        if (left != null) {
            graph.add (left.getValue());
            graph.connectDirected (bst.getValue(), left.getValue());
            convertToGraphRec (left, graph);
        }
        if (right != null) {
            graph.add (right.getValue ());
            graph.connectDirected (bst.getValue(), right.getValue ());
            convertToGraphRec (right, graph);
        }
        
    }
    
}
