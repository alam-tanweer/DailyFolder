package unit06.assignment;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie a, Movie b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return Double.compare(a.getRating(), b.getRating()); // ascending
    }
}
