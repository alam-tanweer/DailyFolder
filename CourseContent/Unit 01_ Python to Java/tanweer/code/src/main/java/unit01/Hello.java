package unit01;

import java.util.Scanner;

public class Hello {
    public static void helloYou() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Enter Age: ");
        int age = scanner.nextInt();
        System.out.println("Age = " + age);

        scanner.nextLine();

        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Address: " + address);

        scanner.close();

    }   

    public static void helloYou2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");

        // String input = scanner.next();
        // System.out.println(input);
        // input = scanner.next();
        // System.out.println(input);
        // input = scanner.next();
        // System.out.println(input);

        String input = scanner.nextLine();
        System.out.println(input);
   
    }

    public static void main(String[] args) {
        helloYou();
        // helloYou2();

    }

}
