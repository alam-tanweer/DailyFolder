package unit04;

public class MethodReference {
    public interface Computation {
        String compute(double x, double y);
    }

    public static void computeAndPrint(Computation c) {
        String result = c.compute(10.5, 2.7);
        System.out.println(result);
    }

    public static class Calculator {
        public String add(double op1, double op2) {
            return op1 + " + " + op2 + " = " + (op1 + op2);
        }

        public String multiply(double op1, double op2) {
            return op1 + " * " + op2 + " = " + (op1 * op2);
        }
    }

    public static class ShapeAreas {
        public String rectangle(double width, double height) {
            return "Rectangle Area: " + width + " * " + " height = " 
                + (width * height);
        }

        public String triangle(double base, double height) {
            return "Triangle Area: 1/2 " + base + " * " + height + " = " 
                + (0.5 * base * height);
        }
    }

    public static class Mathy {
        public static String power(double base, double exponent) {
            return base + "^" + exponent + " = " + Math.pow(base, exponent);
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        computeAndPrint(calc::add);
        computeAndPrint(calc::multiply);

        ShapeAreas areas = new ShapeAreas();
        computeAndPrint(areas::rectangle);
        computeAndPrint(areas::triangle);

        computeAndPrint(Mathy::power);

        computeAndPrint((x, y) -> {
            return "(" + x + ", " + y + ")";
        });

        // computeAndPrint(Math::pow);
    }
}
