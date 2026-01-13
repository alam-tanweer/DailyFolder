package unit01.activities;

public class HelloWorld {
    public static void helloName(String first, String last) {
        System.out.println("Hello, " + first + " " + last + ".");
    }

    public static void main(String[] args) {
        // version 1.0
        // System.out.println("Hello, World!");

        // version 2.0
        helloName("Hermione", "Granger");
    }
    
}
