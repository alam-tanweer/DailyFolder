package unit03.assignment2.toys;

/**
 * Represents a consumer product, such as a Toy or a Car.
 */
public interface Product {
    /**
     * Accesses the product code for this product.
     * 
     * @return The product code for this product.
     */
    int getProductCode();

    /**
     * Accesses the name of the product.
     * 
     * @return The name of the product.
     */
    String getName();

    /**
     * Accesses the manufacturer's suggested retail price (MSRP).
     * 
     * @return The MSRP for this product.
     */
    double getMsrp();
}
