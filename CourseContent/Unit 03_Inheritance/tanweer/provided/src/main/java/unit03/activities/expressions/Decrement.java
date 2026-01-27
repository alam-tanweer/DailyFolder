package unit03.activities;

public class Decrement /* extends Expression */ implements Expression {
    private final Expression expression;

    public Decrement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() - 1;
    }
}
