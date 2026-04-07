package unit07.assignment1.sourceTarget;

import java.util.List;
import unit07.AdjacencyGraph;

public class AdjacencyGraphSTv2<E> {
    private AdjacencyGraph<E> graph;
    private E s;
    private E t;

    @SuppressWarnings("unchecked")
    public AdjacencyGraphSTv2(AdjacencyGraph<E> graph, E[] S, E[] T) {
        this.graph = graph;

        this.s = (E) new Object();
        this.t = (E) new Object();

        graph.add(s);
        graph.add(t);

        for (E start : S) {
            graph.connectDirected(s, start);
        }

        for (E end : T) {
            graph.connectDirected(end, t);
        }
    }

    public boolean bfSearch() {
        return graph.bfSearch(s, t);
    }

    public List<E> bfPath() {
        List<E> path = graph.bfPath(s, t);
        if (path != null) {
            // List<E> newPath = new ArrayList<>();
            // for (int i = 1; i < path.size() - 1; i++) {
            //     newPath.add(path.get(i));
            // }
            // return newPath;
            return path;
        }
        return null;
    }
}
