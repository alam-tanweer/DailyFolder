package unit07.assignment1.concentric;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ConcentricGraph {
    private AdjacencyGraph<String> graph;
    private List<String> centers;

    public ConcentricGraph(String filename) throws IOException {
        graph = new AdjacencyGraph<>();
        centers = new ArrayList<>();
        try (FileReader fr = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fr)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(", ");
                addIfNotPresent(tokens[0]);
                for (int i = 1; i < tokens.length; i++) {
                    addIfNotPresent(tokens[i]);
                    graph.connectUndirected(tokens[0], tokens[i]);
                }
            }
        }
        searchCenters();
    }

    private void addIfNotPresent(String value) {
        if (!graph.contains(value)) {
            graph.add(value);
        }
    }

    private void searchCenters() {
        int radius = radius();
        int maxDeg = 0;
        Map<String, Vertex<String>> vertices = graph.getVertices();
        // Find max deg centers
        for (String start : vertices.keySet()) {
            int dist = distance(start);
            if (dist == radius) {
                int start_deg = vertices.get(start).getNeighbors().size();
                if (start_deg > maxDeg) {
                    maxDeg = start_deg;
                }
            }
        }
        // Add max deg centers to this.centers
        for (String start : vertices.keySet()) {
            int dist = distance(start);
            int deg = vertices.get(start).getNeighbors().size();
            if (dist == radius && deg == maxDeg) {
                centers.add(start);
            }
        }
    }

    public Map<String, Integer> distanceMap(String start) {
        Vertex<String> s = graph.getVertices().get(start);

        Map<String, Integer> distanceMap = new HashMap<>(); // value --> level
        Queue<Vertex<String>> queue = new LinkedList<>();
        distanceMap.put(start, 0);
        queue.add(s);

        while (!queue.isEmpty()) {
            Vertex<String> v = queue.poll();
            int level = distanceMap.get(v.getValue()) + 1;
            for (Vertex<String> n : v.getNeighbors()) {
                if (!distanceMap.containsKey(n.getValue())) {
                    distanceMap.put(n.getValue(), level);
                    queue.add(n);
                }
            }
        }
        return distanceMap;
    }

    public List<String> getCenters() {
        return this.centers;
    }

    public int distance(String start) {
        Map<String, Integer> distanceMap = distanceMap(start);
        int maxDistance = 0;
        for (String key : distanceMap.keySet()) {
            int distance = distanceMap.get(key);
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    public int radius() {
        int radius = Integer.MAX_VALUE;
        Map<String, Vertex<String>> vertices = graph.getVertices();
        for (String start : vertices.keySet()) {
            int dist = distance(start);
            if (dist < radius) {
                radius = dist;
            }
        }
        return radius;
    }

    @Override
    public String toString() {
        Map<String, Vertex<String>> vertices = graph.getVertices();
        Queue<Vertex<String>> queue = new LinkedList<>();
        Map<Vertex<String>, Integer> distanceMap = new HashMap<>();
        String string = "Ring 0: " + centers;

        for (String center : centers) {
            queue.add(vertices.get(center));
            distanceMap.put(vertices.get(center), 0);
        }

        List<String> ring = new ArrayList<>();
        string += "\nRing 1: ";
        int currLevel = 1;
        while (!queue.isEmpty()) {
            Vertex<String> v = queue.poll();
            for (Vertex<String> n : v.getNeighbors()) {
                if (!distanceMap.containsKey(n)) {
                    int level = distanceMap.get(v) + 1;
                    if (level > currLevel) {
                        string += ring;
                        currLevel++;
                        ring = new ArrayList<>();
                        string += "\nRing " + currLevel + ": ";
                    }
                    distanceMap.put(n, level);
                    queue.add(n);
                    ring.add(n.getValue());
                }
            }
        }
        string += ring;

        return string;
    }

    public static void main(String[] args) throws IOException {
        /*
         * ConcentricGraph cGraph = new ConcentricGraph("data/connected_3.txt");
         * 
         * System.out.println("Distance of each vertex from A:");
         * System.out.println(cGraph.distanceMap("A"));
         * System.out.println("distance(A): " + cGraph.distance("A"));
         * System.out.println("Graph radius: " + cGraph.radius());
         * System.out.println("Graph Centers: " + cGraph.getCenters());
         * System.out.println("Concentric Graph:\n" + cGraph); // Bonus credit
         */
        ConcentricGraph cGraph = new ConcentricGraph("data_2215/connected_usa.txt");

        System.out.println("Distance of each state from New York:");
        System.out.println(cGraph.distanceMap("New York"));
        System.out.println("distance(New York): " + cGraph.distance("New York"));
        System.out.println("Graph radius: " + cGraph.radius());
        System.out.println("Graph Centers: " + cGraph.getCenters());
        System.out.println("Concentric Graph:\n" + cGraph); // Bonus Credit
    }
}
