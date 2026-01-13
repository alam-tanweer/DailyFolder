package unit01;

import java.util.Scanner;

public class Slides {
    @SuppressWarnings("unused")
    public static void castingExample() {
        double x = 47.2;
        int y = (int)x; // cast needed
    }

    public static void scannerExample() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age in years: ");
        int age = scanner.nextInt();
        int months = age * 12;
        System.out.println("Age in months: " + months);
        scanner.close();
    }

    public static int factorial(int n) {
        int result = 1;
        while(n > 1) {
            result = result * n;
            n = n - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("factorial(10) = " + factorial(10));
    }
}
