package unit08.weighted;

import java.util.Comparator;
import java.util.Map;

public class WeightComparator<E> implements Comparator<WVertex<E>> {
    private final Map<WVertex<E>, Double> neighbors;

    public WeightComparator(Map<WVertex<E>, Double> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public int compare(WVertex<E> a, WVertex<E> b) {
        double weightA = neighbors.get(a);
        double weightB = neighbors.get(b);

        return weightA < weightB ? -1 : 1;
    }
    
}
