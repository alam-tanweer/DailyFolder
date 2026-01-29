package unit03.parser;

/**
 * A binary subtraction expression (-).
 * Evaluates the left and right expressions, then subtracts right from left.
 */
public class Subtraction /* extends Expression */ implements Expression{

    private Expression left;
    private Expression right;

    /**
     * Constructs a subtraction expression with two operand expressions.
     *
     * @param left  the left operand expression
     * @param right the right operand expression
     */
    public Subtraction(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Evaluates both operand expressions, then returns left minus right.
     *
     * @return left.evaluate() - right.evaluate()
     */
    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    /**
     * Simple test of the Subtraction class.
     */
    public static void main(String[] args) {
        Expression s = new Subtraction(new Constant(10), new Constant(4));
        System.out.println(s.evaluate()); // 6.0

        // nested example: (10 - 3) - 2
        Expression nested = new Subtraction(
                new Subtraction(new Constant(10), new Constant(3)),
                new Constant(2)
        );
        System.out.println(nested.evaluate()); // 5.0
    }
}

