package unit13;

public class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        return 
        Math.PI * radius * radius;
    }
    
    @Override 
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }
}
