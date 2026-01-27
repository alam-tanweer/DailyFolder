package unit03.activities;

public class Addition /* extends Expression */ implements Expression {
    private final Expression expressionOne;
    private final Expression expressionTwo;

    public Addition(Expression expressionOne, Expression expressionTwo) {
        this.expressionOne = expressionOne;
        this.expressionTwo = expressionTwo;
    }

    @Override
    public double evaluate() {
        double one = expressionOne.evaluate();
        double two = expressionTwo.evaluate();
        return one + two;
    }
    
}
