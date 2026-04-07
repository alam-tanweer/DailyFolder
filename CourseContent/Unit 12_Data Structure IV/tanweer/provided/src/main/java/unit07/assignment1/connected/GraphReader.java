package unit07.assignment1.connected;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphReader {
    public static Graph<String> readGraph(String filename) throws IOException {
        try (FileReader fr = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fr)) {
            Graph<String> graph = new AdjacencyGraph<>();

            boolean noEndOfFile = true;
            while (noEndOfFile) {
                String line = reader.readLine();
                if (line == null) {
                    noEndOfFile = false;
                } else {
                    if (line.startsWith("#")) {
                        continue;
                    } else {
                        String[] tokens = line.split(" ");
                        addIfNotPresent(tokens[0], graph);
                        for (int i = 1; i < tokens.length; i++) {
                            addIfNotPresent(tokens[i], graph);
                            graph.connectUndirected(tokens[0], tokens[i]);
                        }
                    }
                }
            }

            return graph;
        }
    }

    private static void addIfNotPresent(String value, Graph<String> graph) {
        if (!graph.contains(value)) {
            graph.add(value);
        }
    }
}