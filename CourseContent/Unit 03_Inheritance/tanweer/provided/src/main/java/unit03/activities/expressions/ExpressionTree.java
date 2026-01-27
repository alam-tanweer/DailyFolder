package unit03.activities;

public class ExpressionTree {
    public static void main(String[] args) {
        Constant c3 = new Constant(3);
        Increment inc = new Increment(c3);

        Constant c5 = new Constant(5);
        Decrement dec = new Decrement(c5);

        Subtraction sub = new Subtraction(inc, dec);

        Constant c16 = new Constant(16);
        Expression sqrt = () -> { 
            double value = c16.evaluate();
            return Math.sqrt(value);
        };

        Addition addition = new Addition(sub, sqrt);
        System.out.println(addition.evaluate());
    }
}
