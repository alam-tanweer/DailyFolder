package practicum02.packages;

public enum Priority {
    HIGH(1),
    MEDIUM(2),
    LOW(3);

    private int rank;

    private Priority(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}