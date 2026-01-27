package unit03.activities;

public class Constant /* extends Expression */ implements Expression {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }    
}
