package unit03.parser;

public class ExpressionExample {
    public static void main(String[] args) {
        Expression c1 = new Constant(5);
        Expression c2 = new Constant(3.14159);

        System.out.println(c1.evaluate()); // 5.0
        System.out.println(c2.evaluate()); // 3.14159


        Expression inc = new Increment(c1);
        System.out.println(inc.evaluate()); // 6.0

        //nested unary expression: ++(++5)
        Expression nested = new Increment(new Increment(new Constant(5)));
        System.out.println(nested.evaluate()); // 7.0        

        Expression a = new Addition(new Constant(2), new Constant(3));
        System.out.println(a.evaluate()); // 5.0

        // nested example: 2 + (3 + 4)
        Expression nested2 = new Addition(
                new Constant(2),
                new Addition(new Constant(3), new Constant(4))
        );
        System.out.println(nested2.evaluate()); // 9.0

        int a1 = 10;
        int b1 = 10;
        int i = a1++ + b1++;
        System.out.println(i + "  " + a1 + "   " + b1);

    }
}
