package unit04.Example;

import java.util.Scanner;

public class UserShapes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a shape to create (circle, rectangle, triangle) or 'exit' to quit:");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("exit")) {
                break;
            }

            Shape shape = null;

            switch (choice) {
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
                    scanner.nextLine();
                    shape = ShapeFactory.createRectangle(width, height);
                    break;

                case "triangle":
                    System.out.print("Enter side A: ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter side B: ");
                    double b = scanner.nextDouble();
                    System.out.print("Enter side C: ");
                    double c = scanner.nextDouble();
                    scanner.nextLine();
                    shape = ShapeFactory.createTriangle(a, b); 
                    // assuming right triangle (a,b legs)
                    break;

                default:
                    System.out.println("Unknown shape type. Please try again.");
                    continue;
            }

            System.out.println("Area: " + shape.area());
            System.out.println("Perimeter: " + shape.perimeter());
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}

