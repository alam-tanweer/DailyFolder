package Day02;

import java.util.HashMap;
import java.util.Map;

public class ShapeExample {
    public interface Shape {
        double area (double length);
    }

    public static double triangleArea (double side) {
        return Math.sqrt(3) * Math.pow (side, 2) / 4;
    }

    public static void main (String[] args) {
        int length = 5;

        Shape square = new Shape () {
            public double area (double length) {
                return length * length;
            }
        };
      
        System.out.println ("Square area = " + square.area (length));

        Shape circle = (double radius) -> {
            return Math.PI * Math.pow (radius, 2);
        };
        System.out.println ("Circle area = " + circle.area (length));

        int height = 10;
        Shape rectangle = width -> width * height;
        System.out.println ("Rectangle area = " + rectangle.area (length));

        Shape triangle = ShapeExample::triangleArea;
        System.out.println ("Triangle area = " + triangle.area(length));

        System.out.println ();

        Map <String, Shape> shapes = new HashMap<> ();
        shapes.put ("Square", square);
        shapes.put ("Circle", circle);
        shapes.put ("Rectangle", rectangle);
        shapes.put ("Triangle", triangle);

        for (String shape : shapes.keySet ()) {
            System.out.println (shape + "area = " + shapes.get (shape).area (length));
        }

    }  
}
