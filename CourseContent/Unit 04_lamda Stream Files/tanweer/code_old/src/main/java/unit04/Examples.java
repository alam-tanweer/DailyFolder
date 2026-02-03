package unit04;

public class Examples {
    public static void main(String[] args) {
        Outer outer = new Outer(0);
        outer.ClassMethod();
        Outer.Inner oi = new Outer(0).new Inner(null);
        Outer.Inner.InnerInner oii = new Outer(0).new Inner(null).new InnerInner(null);

        Outer.StaticInner si = new Outer.StaticInner(null);

        
        Shape circle = ShapeFactory.createCircle(5);
        Shape rectangle = ShapeFactory.createRectangle(4, 6);
        Shape triangle = ShapeFactory.createTriangle(3, 4);

        System.out.println("Circle area: " + circle.area());
        System.out.println("Circle perimeter: " + circle.perimeter());

        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Rectangle perimeter: " + rectangle.perimeter());

        System.out.println("Triangle area: " + triangle.area());
        System.out.println("Triangle perimeter: " + triangle.perimeter());        
    }
}
