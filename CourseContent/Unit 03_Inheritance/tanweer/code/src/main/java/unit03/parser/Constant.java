package unit03.parser;

/**
 * A constant expression that always evaluates to the same value.
 */
public class Constant /* extends Expression */ implements Expression {

    private double value;

    /**
     * Constructs a constant expression with the given value.
     *
     * @param value the numeric value of this constant
     */
    public Constant(double value) {
        this.value = value;
    }

    /**
     * Evaluates this constant expression.
     * Always returns the stored constant value.
     *
     * @return the constant value
     */
    @Override
    public double evaluate() {
        return value;
    }

    /**
     * Simple test of the Constant class.
     */
    public static void main(String[] args) {
        Expression c1 = new Constant(5);
        Expression c2 = new Constant(3.14159);

        System.out.println(c1.evaluate()); // 5.0
        System.out.println(c2.evaluate()); // 3.14159
    }
}

