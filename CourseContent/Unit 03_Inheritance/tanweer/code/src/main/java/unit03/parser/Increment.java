package unit03.parser;

/**
 * A unary increment expression (++), which evaluates its inner expression
 * and then adds 1 to the result.
 */
public class Increment /* extends Expression */ implements Expression{

    private Expression operand;

    /**
     * Constructs an increment expression with the given operand.
     *
     * @param operand another expression to be incremented
     */
    public Increment(Expression operand) {
        this.operand = operand;
    }

    /**
     * Evaluates the operand expression first, then adds 1.
     *
     * @return operand value + 1
     */
    @Override
    public double evaluate() {
        return operand.evaluate() + 1;
    }

    /**
     * Simple test of the Increment class.
     */
    public static void main(String[] args) {
        Expression c = new Constant(5);
        Expression inc = new Increment(c);

        System.out.println(inc.evaluate()); // 6.0

        // nested unary expression: ++(++5)
        Expression nested = new Increment(new Increment(new Constant(5)));
        System.out.println(nested.evaluate()); // 7.0
    }
}
