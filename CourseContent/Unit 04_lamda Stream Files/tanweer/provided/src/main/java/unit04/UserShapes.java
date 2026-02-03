package unit04;

import java.util.Scanner;

public class UserShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose a shape to create (circle, rectangle, triangle) or 'exit' to quit:");
            String shapeType = scanner.nextLine().toLowerCase();

            if (shapeType.equals("exit")) {
                break;
            }

            Shape shape = null;

            switch (shapeType) {
                case "circle":
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    shape = ShapeFactory.createCircle(radius);
                    break;
                case "rectangle":
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    shape = ShapeFactory.createRectangle(width, height);
                    break;
                case "triangle":
                    System.out.print("Enter side A: ");
                    double sideA = scanner.nextDouble();
                    System.out.print("Enter side B: ");
                    double sideB = scanner.nextDouble();
                    System.out.print("Enter side C: ");
                    double sideC = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    shape = ShapeFactory.createTriangle(sideA, sideB, sideC);
                    break;
                default:
                    System.out.println("Unknown shape type. Please try again.");
                    continue;
            }

            if (shape != null) {
                System.out.println("Area: " + shape.area());
                System.out.println("Perimeter: " + shape.perimeter());
            }
        }

        scanner.close ();
    }
}
