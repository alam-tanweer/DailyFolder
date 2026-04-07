package unit07.assignment1.sourceTarget;

import java.io.IOException;
import java.util.List;
import unit07.AdjacencyGraph;

public class AdjacencyGraphST<E> {
    private AdjacencyGraph<E> graph;
    private E[] S;
    private E[] T;

    public AdjacencyGraphST(AdjacencyGraph<E> graph, E[] S, E[] T) throws IOException {
        this.graph = graph;
        this.S = S;
        this.T = T;
    }

    public boolean bfSearch() {
        for (E start : this.S) {
            for (E end : this.T) {
                boolean pathExists = graph.bfSearch(start, end);
                if (pathExists) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<E> bfPath() {
        List<E> minPath = null;
        int minPathLength = Integer.MAX_VALUE;
        for (E start : S) {
            for (E end : T) {
                List<E> path = graph.bfPath(start, end);
                if (path != null && path.size() < minPathLength) {
                    minPath = path;
                    minPathLength = path.size();
                }
            }
        }
        return minPath;
    }

}
