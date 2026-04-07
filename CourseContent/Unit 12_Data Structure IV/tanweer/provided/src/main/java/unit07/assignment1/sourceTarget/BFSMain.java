package unit07.assignment1.sourceTarget;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import unit07.AdjacencyGraph;

public class BFSMain {
    public static AdjacencyGraph<String> makeAdjacencyGraph(BufferedReader reader) throws IOException {
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(" ");
            if (!graph.contains(tokens[0])) {
                graph.add(tokens[0]);
            }
            for (int i = 1; i < tokens.length; i++) {
                if (!graph.contains(tokens[i])) {
                    graph.add(tokens[i]);
                }
                graph.connectDirected(tokens[0], tokens[i]);
            }
        }
        return graph;

    }

    public static AdjacencyGraphST<String> makeAdjacencyGraphST(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {
            String[] S = reader.readLine().split(" ");
            String[] T = reader.readLine().split(" ");
            AdjacencyGraph<String> graph = makeAdjacencyGraph(reader);
            return new AdjacencyGraphST<>(graph, S, T);
        }
    }

    public static AdjacencyGraphSTv2<String> makeAdjacencyGraphSTv2(String filename) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {

            String[] S = reader.readLine().split(" ");
            String[] T = reader.readLine().split(" ");

            AdjacencyGraph<String> graph = makeAdjacencyGraph(reader);

            return new AdjacencyGraphSTv2<>(graph, S, T);
        }
    }

    public static void main(String[] args) throws IOException {
        AdjacencyGraphSTv2<String> graphv2 = makeAdjacencyGraphSTv2("data/bfs/graph1.txt");
        System.out.println(graphv2.bfSearch());
        System.out.println(graphv2.bfPath());
        java.util.List<String> path = graphv2.bfPath();
        for(String s : path) {
            System.out.println(s);
        }

        AdjacencyGraphST<String> graph = makeAdjacencyGraphST("data/bfs/graph1.txt");
        System.out.println(graph.bfSearch());
        System.out.println(graph.bfPath());
    }

}
