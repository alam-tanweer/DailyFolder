package unit13;

import java.util.Scanner;

public class Output {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Hello, " + name);

        sc.close ();
    }
}
