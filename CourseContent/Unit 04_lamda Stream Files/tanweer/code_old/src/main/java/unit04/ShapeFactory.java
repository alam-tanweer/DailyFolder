package unit04;

public class ShapeFactory {

    public static Shape createCircle(double radius) {
        return new Shape() {
            @Override
            public double area() {
                return Math.PI * radius * radius;
            }

            @Override
            public double perimeter() {
                return 2 * Math.PI * radius;
            }
        };
    }

    public static Shape createRectangle(double width, double height) {
        return new Shape() {
            @Override
            public double area() {
                return width * height;
            }

            @Override
            public double perimeter() {
                return 2 * (width + height);
            }
        };
    }

    // assume right triangle
    public static Shape createTriangle(double base, double height) {
        return new Shape() {
            @Override
            public double area() {
                return 0.5 * base * height;
            }

            @Override
            public double perimeter() {
                double hyp = Math.sqrt(base * base + height * height);
                return base + height + hyp;
            }
        };
    }
}

