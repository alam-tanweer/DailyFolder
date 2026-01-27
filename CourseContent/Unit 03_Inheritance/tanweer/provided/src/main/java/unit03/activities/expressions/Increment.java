package unit03.activities;

public class Increment /* extends Expression */ implements Expression {
    private final Expression expression;

    public Increment(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() + 1;
    }
}
