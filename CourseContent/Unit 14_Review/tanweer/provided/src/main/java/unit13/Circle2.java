package unit13;

public class Circle2 extends AbstractShape {
    private double radius;

    public Circle2(double radius) {
        super ("circle");
        this.radius = radius;
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
