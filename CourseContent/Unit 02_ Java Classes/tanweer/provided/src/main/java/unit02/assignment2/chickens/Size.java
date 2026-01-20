package unit02.assignment2.chickens;

public enum Size {
    PEEWEE(15),
    SMALL(18),
    MEDIUM(21),
    LARGE(24),
    EXTRA_LARGE(27),
    JUMBO(30);

    private final int ounces;

    private Size(int ounces) {
        this.ounces = ounces;
    }

    public int getOunces() {
        return ounces;
    }
}
