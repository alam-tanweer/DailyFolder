package unit06.assignment;

public class Movie implements Comparable<Movie> {
    private String title;
    private String genre;
    private double rating;

    public Movie(String title, String genre, double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return title + ", " + genre + ", " + rating;
    }

    @Override
    public int compareTo(Movie other) {
        if (other == null) return 1;

        // 1) Genre ascending
        int genreCmp = this.genre.compareTo(other.genre);
        if (genreCmp != 0) return genreCmp;

        // 2) Rating descending
        int ratingCmp = Double.compare(other.rating, this.rating);
        if (ratingCmp != 0) return ratingCmp;

        // 3) Title ascending
        return this.title.compareTo(other.title);
    }
}
