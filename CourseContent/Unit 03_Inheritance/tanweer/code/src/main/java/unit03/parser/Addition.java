package unit03.parser;

/**
 * A binary addition expression (+).
 * Evaluates the left and right expressions, then adds the results.
 */
public class Addition /* extends Expression */ implements Expression {

    private Expression left;
    private Expression right;

    /**
     * Constructs an addition expression with two operand expressions.
     *
     * @param left  the left operand expression
     * @param right the right operand expression
     */
    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Evaluates both operand expressions, then returns their sum.
     *
     * @return left.evaluate() + right.evaluate()
     */
    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    /**
     * Simple test of the Addition class.
     */
    public static void main(String[] args) {
        Expression a = new Addition(new Constant(2), new Constant(3));
        System.out.println(a.evaluate()); // 5.0

        // nested example: 2 + (3 + 4)
        Expression nested = new Addition(
                new Constant(2),
                new Addition(new Constant(3), new Constant(4))
        );
        System.out.println(nested.evaluate()); // 9.0
    }
}

