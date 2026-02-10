package unit05.assignment2.ranges;

public interface Range extends Iterable<Integer> {
    int size();

    int get(int index);
}