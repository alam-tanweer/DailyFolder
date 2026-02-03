package unit04.Example;

public class Example {
    public static void main(String[] args) {
        Outer outer = new Outer(0);
        outer.ClassMethod();
        Outer.Inner oi = new Outer(0).new Inner(null);
        Outer.Inner.InnerInner oii = new Outer(0).new Inner(null).new InnerInner(null);

        Outer.StaticInner si = new Outer.StaticInner(null);

        // Shape circle = ShapeFactory.createCircle(5);
        // Shape rectangle = ShapeFactory.createRectangle(4, 6);
        // Shape triangle = ShapeFactory.createTriangle(3, 4);

        // System.out.println("Circle area: " + circle.area());
        // System.out.println("Circle perimeter: " + circle.perimeter());

        // System.out.println("Rectangle area: " + rectangle.area());
        // System.out.println("Rectangle perimeter: " + rectangle.perimeter());

        // System.out.println("Triangle area: " + triangle.area());
        // System.out.println("Triangle perimeter: " + triangle.perimeter());


        //Functional Interface
        // FunctInterface fi = (x,y) -> x + y;
        FunctInterface fi = (x,y) -> {
            System.out.println("FI : " + (x + y));
            return x + y;
        };

        // FunctInterface fi = new FunctInterface() {
        //     public int add(int a, int b) {
        //         return a + b;
        //     }
        // };
        System.out.println(fi.add(10, 10));

        //Method reference
        FunctInterface fm = Example::addNumbers;
        System.out.println("Adding numbers : " + fm.add(2,2));

        computeAndPrint((x,y) -> "Result: " + (x+y));

        Calculator calc = new Calculator();
        computeAndPrint(calc::add);
        computeAndPrint(Calculator::multiply);   //Static reference. No need to create instance.

    }

    public static int addNumbers(int a, int b){
        return a + b;
    }

    public static void computeAndPrint(Computation c){
        String result = c.compute(10, 2);
        System.out.println(result);
    }
}
