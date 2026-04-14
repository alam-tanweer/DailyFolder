package unit08.weighted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing a vertext in a weighted graph.
 * 
 * @author GCCIS Faculty
 */
public class WVertex<E> implements Comparator<WVertex<E>> {
    private final E value;
    private final Map<WVertex<E>, Double> neighbors;

    /**
     * Creates a new vertex with the specified value.
     * 
     * @param value The value contained by this vertex.
     */
    public WVertex(E value) {
        this.value = value;
        this.neighbors = new HashMap<>();
    }

    public E getValue() {
        return this.value;
    }

    /**
     * Connects this vertex to a neighbor with the specified weight.
     * 
     * @param neighbor The neighbor vertex.
     * @param weight The weight or cost of the edge to the neighbor.
     */
    public void connect(WVertex<E> neighbor, double weight) {
        neighbors.put(neighbor, weight);
    }

    /**
     * Returns true if the vertex is a neighbor, and false otherwise.
     * 
     * @param vertex The vertex.
     * @return True if the vertex is aneighbor, and false otherwise.
     */
    public boolean connected(WVertex<E> vertex) {
        return neighbors.containsKey(vertex);
    }

    /**
     * Returns the weight of the edge connecting to the specified neighbor.
     * 
     * @param neighbor The neighbor vertex.
     * @return The weight of the edge to the neighbor.
     */
    public double weight(WVertex<E> neighbor) {
        return neighbors.get(neighbor);
    }

    /**
     * Returns the map of neighbors and weights.
     * 
     * @return The map of neighbors and weights.
     */
    public Map<WVertex<E>, Double> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compare(WVertex<E> a, WVertex<E> b) {
        double weightA = neighbors.get(a);
        double weightB = neighbors.get(b);

        return weightA < weightB ? -1 : 1;
    }

    public List<WVertex<E>> getNearestNeighbors() {
        List<WVertex<E>> nearest = new ArrayList<>(neighbors.keySet());
        Collections.sort(nearest, this);
        return nearest;
    }
}
