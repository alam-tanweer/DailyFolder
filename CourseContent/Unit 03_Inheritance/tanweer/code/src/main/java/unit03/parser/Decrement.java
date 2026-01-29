package unit03.parser;

/**
 * A unary decrement expression (--), which evaluates its inner expression
 * and then subtracts 1 from the result.
 */
public class Decrement /* extends Expression */ implements Expression{

    private Expression operand;

    /**
     * Constructs a decrement expression with the given operand.
     *
     * @param operand another expression to be decremented
     */
    public Decrement(Expression operand) {
        this.operand = operand;
    }

    /**
     * Evaluates the operand expression first, then subtracts 1.
     *
     * @return operand value - 1
     */
    @Override
    public double evaluate() {
        return operand.evaluate() - 1;
    }

    /**
     * Simple test of the Decrement class.
     */
    public static void main(String[] args) {
        Expression c = new Constant(5);
        Expression dec = new Decrement(c);

        System.out.println(dec.evaluate()); // 4.0

        // nested unary expression: --(--5)
        Expression nested = new Decrement(new Decrement(new Constant(5)));
        System.out.println(nested.evaluate()); // 3.0
    }
}
