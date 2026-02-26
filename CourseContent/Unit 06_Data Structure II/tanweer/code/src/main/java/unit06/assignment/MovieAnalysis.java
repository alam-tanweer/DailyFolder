package unit06.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class MovieAnalysis {

    public static List<Movie> buildMovieList(String filename) {
        List<Movie> movies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // If the first line is a header, you can skip it.
            // We'll detect header by checking if it contains "title" and "genre".
            boolean first = true;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                if (first) {
                    first = false;
                    String lower = line.toLowerCase();
                    if (lower.contains("title") && lower.contains("genre")) {
                        continue; // skip header
                    }
                }

                // Simple CSV split (works if no commas inside title/genre)
                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                String title = parts[0].trim();
                String genre = parts[1].trim();
                double rating = Double.parseDouble(parts[2].trim());

                movies.add(new Movie(title, genre, rating));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filename, e);
        }

        return movies;
    }

    public static List<Movie> sortMovies(List<Movie> movies) {
        return movies.stream()
                .sorted() // uses Movie.compareTo (natural order)
                .collect(Collectors.toList());
    }

    public static Movie getTopRatedMovie(List<Movie> movies) {
        return movies.stream()
                .max(new RatingComparator()) // comparator is ascending
                .orElse(null);
    }

    public static Movie getLowestRatedMovie(List<Movie> movies) {
        return movies.stream()
                .min(new RatingComparator())
                .orElse(null);
    }

    public static void main(String[] args) {
        String filename = "Unit06/data/movies.csv"; // per assignment

        List<Movie> movies = buildMovieList(filename);

        System.out.println("=== Original Movies ===");
        for (Movie m : movies) {
            System.out.println(m);
        }

        System.out.println("\n=== Sorted Movies (Natural Order) ===");
        List<Movie> sorted = sortMovies(movies);
        for (Movie m : sorted) {
            System.out.println(m);
        }

        Movie top = getTopRatedMovie(movies);
        Movie low = getLowestRatedMovie(movies);

        System.out.println("\n=== Top Rated Movie ===");
        System.out.println(top);

        System.out.println("\n=== Lowest Rated Movie ===");
        System.out.println(low);
    }
}
