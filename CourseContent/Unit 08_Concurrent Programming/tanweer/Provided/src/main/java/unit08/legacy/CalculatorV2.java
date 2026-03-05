package unit08.legacy;

public class CalculatorV2 {

    // inner class
    public interface Operation {
        public double execute (double left, double right);
    }

    // inner class which implements interface
    public static class division implements Operation{
        @Override
        public double execute(double left, double right) {
            return left / right;
        }
    }

    // static method for method reference
    public static double multiply(double left, double right) {
        return left * right;
    }

    public static Operation getOperation(String operation) {
        // Anonymouns class
        if (operation.equals("+")) {
            return new Operation() {
                public double execute(double left, double right) {
                    return left + right;
                }
            };
        // Use inner class
        } else if (operation.equals("/")) {
            return new CalculatorV2.division();
        // Lambda
        } else if (operation.equals("-")) {
            return (left, right) -> left - right;
        // Method reference
        } else if (operation.equals("*")) {
            return CalculatorV2::multiply;
        // method reference
        } else if (operation.equals("^")) {
            return Math::pow;
        }   else {
            return null;
        }
    }

    public static void main(String[] args) {
        double op1 = 5.0;
        double op2 = 6.0;
        Operation op = getOperation("+");
        System.out.println(op.execute(op1, op2));
        System.out.println(getOperation("-").execute(op1, op2));
        System.out.println(getOperation("/").execute(op1, op2));
        System.out.println(getOperation("*").execute(op1, op2));
        System.out.println(getOperation("^").execute(op1, op2));
    }

}
