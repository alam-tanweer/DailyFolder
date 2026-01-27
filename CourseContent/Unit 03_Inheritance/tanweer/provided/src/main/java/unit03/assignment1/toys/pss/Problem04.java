package unit03.assignment1.toys.pss;

/** */
@SuppressWarnings("unused")
public abstract class Problem04 { // Toy
    private final int productCode;
    private final String name;
    private final double msrp;

    public Problem04(int productCode, String name, double msrp) {
        this.productCode = productCode;
        this.name = name;
        this.msrp = msrp;
    }

    public abstract void play();
}
