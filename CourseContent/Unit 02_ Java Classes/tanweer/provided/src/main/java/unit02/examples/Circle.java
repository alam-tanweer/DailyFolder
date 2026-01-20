package unit02.examples;

public class Circle {
    public static final double PI = 3.14;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double circumference() {
        return PI * radius * 2;
    }

    public double area() {
        return PI * radius * radius;
    }
}
    

