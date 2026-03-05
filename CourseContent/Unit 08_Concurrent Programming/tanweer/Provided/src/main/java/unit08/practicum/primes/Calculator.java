package unit08.practicum.primes;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Map<Operation,Expression> operations;

    public enum Operation {
        PLUS('+'),
        MINUS('-'),
        DIVIDED_BY('/'),
        TIMES('X');

        private char symbol;

        private Operation(char symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return String.valueOf(symbol);
        }
    };

    private interface Expression {
        double evaluate(double operand1,double operand2);
    };

    static {
        operations = new HashMap<>();
        operations.put(Operation.PLUS,(op1,op2) -> op1 + op2);
        operations.put(Operation.MINUS,(op1,op2) -> op1 - op2);
        operations.put(Operation.DIVIDED_BY,(op1,op2) -> op1 / op2);
        operations.put(Operation.TIMES,(op1,op2) -> op1 * op2);
    }

    public static double calculate(double operand1,Operation op,double operand2) {
        Expression operation = operations.get(op);
        double result = operation.evaluate(operand1,operand2);
        System.out.println(operand1 + " " + op + " " + operand2 + " = " + result);
        return result;
    }

    public static void main(String[] args) {
        calculate(5,Operation.PLUS,2);
        calculate(3.4,Operation.MINUS,8.7);
        calculate(2.1,Operation.TIMES,5.6);
        calculate(8,Operation.DIVIDED_BY,2);
    }
}
