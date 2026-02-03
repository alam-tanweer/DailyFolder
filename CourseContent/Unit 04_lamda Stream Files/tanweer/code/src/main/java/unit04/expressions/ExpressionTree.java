package unit04.expressions;

import java.util.function.DoubleBinaryOperator;

public class ExpressionTree {

    /**
     * Builds an expression tree from a string expression.
     * (Does not follow PEDMAS which would require more complex parsing)
     * @param expr The string expression (e.g., "3 + 5 --")
     * @return The root of the expression tree
     */
    private static Expression buildExpressionTree(String expr) {
        // Local variables to hold parts of the expression
        Expression[] operands = {null, null};
        String operator = null;
        Expression expression = null;

        // Split the expression into parts
        String[] parts = expr.split(" ");
        for (String part : parts) {
            // Create constant
            if (part.matches("\\d+")) { // Check if part is a number
                operands[1] = new Constant(Double.parseDouble(part));
            }
            // Store operator
            else {
                operator = part;
            }

            // Build the expression tree
            if (operator != null) {
                if (operands[0] == null && !operator.equals("++") && !operator.equals("--")){
                    // First operand for a binary operator
                    operands[0] = operands[1];
                } else {
                    // Unary operators
                    if (operator.equals("++") || operator.equals("--")) {
                        if (operator.equals("++")) {
                            expression = new Increment(operands[1]);
                        } else {
                            expression = new Decrement(operands[1]);
                        }
                    } 
                    // Binary operators
                    else { 
                        if (operator.equals("+")) {
                            expression = new Addition(operands[0], operands[1]);
                        } else if (operator.equals("-")) {
                            expression = new Subtraction(operands[0], operands[1]);
                        } else if (operator.equals("*")) {

                            Expression left = operands[0];
                            Expression right = operands[1];
                            expression = () -> left.evaluate() * right.evaluate();

                            // This will throw error. As on line 74 it is being set to null. 
                            // Operands[0] is pointing to specific value in array. where in the above case
                            // value itself is used to set to local variable.
                            // expression = () -> operands[0].evaluate() * operands[1].evaluate();                            
                        }
                        else if (operator.equals("/")) {
                            final Expression left = operands[0];
                            final Expression right = operands[1];
                            expression = () -> left.evaluate() / right.evaluate();
                        }
                        else if (operator.equals("^")) {
                            final Expression left = operands[0];
                            final Expression right = operands[1];
                            // DoubleBinaryOperator op = Math::pow;
                            // expression = () ->  op.applyAsDouble(left.evaluate() , right.evaluate());
                            PowerExpr pe = Math::pow;
                            expression = () -> pe.powerup(left.evaluate(),right.evaluate());

                        }                        
                    }
                    operands[0] = null;
                    operands[1] = expression;
                    operator = null;
                }
            }
        }
        return expression;
    }

    public static void main(String[] args) {

        // Constant c3 = new Constant(3);
        // Increment inc = new Increment(c3);

        // Constant c5 = new Constant(5);
        // Decrement dec = new Decrement(c5);

        // Subtraction sub = new Subtraction(inc, dec);

        // Addition addition = new Addition(sub, dec);

        // System.out.println(addition.evaluate());

        // Expression exprTree = buildExpressionTree("12 ++ - 5 + 20 -- ");
        // System.out.println(exprTree.evaluate());

        // Expression mul = new Expression() {
        // @Override
        // public double evaluate(){
        // return c3.evaluate() * c5.evaluate();
        // }
        // };

        // Expression mul = () -> c3.evaluate() * c5.evaluate();
        // System.out.println(mul.evaluate());

        // Expression exprTree1 = buildExpressionTree("* 10 15");
        // System.out.println(exprTree1.evaluate());

        // Expression div = buildExpressionTree("20 / 5");
        // System.out.println(div.evaluate()); // 4.0

        Expression div = buildExpressionTree(" * 1 2");
        System.out.println(div.evaluate()); // 4.0

    }
}
