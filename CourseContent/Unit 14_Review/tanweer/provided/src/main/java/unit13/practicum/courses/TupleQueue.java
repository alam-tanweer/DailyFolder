package unit04.practicum.courses;

import java.util.LinkedList;
import java.util.List;

public class TupleQueue<E> {

    private final List<PathTuple<E>> queue;

    public TupleQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(PathTuple<E> element) {
        queue.add(element);        
    }

    public PathTuple<E> dequeue() {
        PathTuple<E> shortest = queue.get(0);
        int index = 0;

        for(int i=1; i<queue.size(); i++) {
            PathTuple<E> pt = queue.get(i);
            if(pt.getDistance() < shortest.getDistance()) {
                shortest = pt;
                index = i;
            }
        }

        queue.remove(index);

        return shortest;
    }

    public int size() {
        return queue.size();
    }
    
}
