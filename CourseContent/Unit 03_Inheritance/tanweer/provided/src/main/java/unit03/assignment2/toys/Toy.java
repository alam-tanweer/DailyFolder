package unit03.assignment2.toys;

/**
 * An abstract class representing a toy. All toys have a product code, name,
 * msrp, and discount. Toys can be played with, but each type of toy does
 * something different if/when it is played with.
 */
public abstract class Toy implements Product {
    /**
     * Used to automatically assign product codes to toys as they are made.
     */
    private static int PRODUCT_CODE = 1000000;

    /**
     * The unique 7-character product code that is a case insensitive mix of
     * letters and numbers.
     */
    private final int productCode;

    /**
     * The name of the toy.
     */
    private final String name;

    /**
     * The manufacturer's suggested retail price for the toy.
     */
    private final double msrp;

    /**
     * Creates a new toy with the specified attributes. The discount is set
     * to a default value of 0.
     * 
     * @param name The name of the toy.
     * @param msrp The manufacturer's suggested retail price for the toy.
     */
    public Toy(String name, double msrp) {
        this.productCode = PRODUCT_CODE++;
        this.name = name;
        this.msrp = msrp;
    }

    /**
     * Called when the toy is played with. Each toy behaves differently when
     * it is played with.
     */
    public abstract void play();

    /**
     * Returns the unique, 7-character product code for this toy. The product
     * code consists of letters and numbers, and is case insensitive.
     * 
     * @return The product code for this toy.
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * Returns the name of the toy.
     * 
     * @return The name of the toy.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the manufacturer's suggested retail price for the toy.
     * 
     * @return The manufacturer's suggested retail price for the toy.
     */
    public double getMsrp() {
        return msrp;
    }
}
