package unit01;

import java.util.Scanner;

/**
 * 1.2.4
 */
public class Hello {
    public static void helloYou() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        scanner.close();
    }   

    public static void main(String[] args) {
        helloYou();
    }
}
