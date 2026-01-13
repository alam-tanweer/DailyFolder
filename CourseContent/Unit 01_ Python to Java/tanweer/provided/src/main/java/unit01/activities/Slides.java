package unit01.activities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Slides {
    @SuppressWarnings({"resource", "unused"})
    public static void promptForInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int x = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Invalid integer!");
        }
    }

    public static int natSum(int n) {
        if(n <= 0) {
            return 0;
        } else {
            int sum = 0;
            while(n > 0) {
                sum += n;
                n = n - 1;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int total = natSum(100);
        System.out.println("Sum 1-100: " + total);
    }

    @SuppressWarnings({"unused"})
    public void fileStuff() {
        File file = new File("a_file.txt");
        String path = file.getAbsolutePath();
        long size = file.length();
        boolean exists = file.exists();
    }   

    @SuppressWarnings({"unused"})
    public static void readText() throws IOException {
        FileReader file = new FileReader("a_file.txt");
        BufferedReader reader = new BufferedReader(file);
        String line = reader.readLine();
        reader.close();
        file.close();
    }

    public static String readLine() throws IOException {
        FileReader file = new FileReader("a_file.txt");
        BufferedReader reader = new BufferedReader(file);
        String line = reader.readLine();
        reader.close();
        return line;
    }

    public static void textWriteExample() throws IOException {
        FileWriter file = new FileWriter("a_file.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print("Your age is: ");
        writer.print(18);
        writer.println(" years old.");
        writer.flush();
        writer.close();
    }

    public static void tryWithResources() throws IOException {
        String name = "data.txt";
        try(FileOutputStream out = new FileOutputStream(name);
            PrintWriter writer = new PrintWriter(out)) {
            writer.println("Hello, File!");
            writer.flush();
        }
    }
}
