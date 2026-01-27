package unit03.assignment2.toys;

/**
 * Interface for a factory that produces products of some kind.
 */
public interface Factory {
    /**
     * Creates and returns a new Product.
     * 
     * @return The newly product.
     */
    public abstract Product manufacture();
}
