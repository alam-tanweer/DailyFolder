package unit13.assignment1.bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit13.graphs.Graph;

public class BstAsGraphTest {
    
    @Test
    public void TestMakeBST () {
        // Setup
        int[] array = {4, 7, 2, 5, 1, 8, 3};
        String expected = "1 2 3 4 5 7 8";

        // Invoke
        BinaryNode bst = BstAsGraph.makeBST (array);

        // Analysis
        String actual = bst.infixTraversal().trim ();
        assertEquals (expected, actual);
    }

    @Test
    public void TestConvertToGraph () {
        // Setup
        int[] array = {4, 7, 2, 5, 1, 8, 3};
        BinaryNode bst = BstAsGraph.makeBST (array);
        boolean is2ChildOf4 = true;
        boolean is4ChildOf2 = false;
        boolean is3ChildOf4 = true;
        boolean is5ChildOf7 = true;
        boolean is6ChildOf5 = false;

        // Invoke
        Graph <Integer> graph = BstAsGraph.convertToGraph (bst);

        // Analysis
        assertEquals (array.length, graph.size());
        assertEquals (is2ChildOf4, graph.connected (4, 2));
        assertEquals (is4ChildOf2, graph.connected (2, 4));
        assertEquals (is3ChildOf4, graph.bfSearch (4, 3));
        assertEquals (is5ChildOf7, graph.bfSearch (7, 5));
        assertEquals (is6ChildOf5, graph.bfSearch (5, 6));
    }
}
