package unit04;

public class ShapeFactory {
    public static Shape createCircle(double radius) {
        return new Shape() {
            @Override
            public double area() { return Math.PI * radius * radius; }

            @Override
            public double perimeter() { return 2 * Math.PI * radius; }
        };
    }

    public static Shape createRectangle(double width, double height) {
        return new Shape() {
            @Override
            public double area() { return width * height; }

            @Override
            public double perimeter() { return 2 * (width + height); }
        };
    }

    public static Shape createTriangle(double sideA, double sideB, double sideC) {
        return new Shape() {
            @Override
            public double area() {
                double s = (sideA + sideB + sideC) / 2;
                return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
            }

            @Override
            public double perimeter() { return sideA + sideB + sideC; }
        };
    }

    public static void main(String[] args) {
        Shape circle = ShapeFactory.createCircle(5);
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        Shape rectangle = ShapeFactory.createRectangle(4, 6);
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());

        Shape triangle = ShapeFactory.createTriangle(3, 4, 5);
        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());
    }
}
