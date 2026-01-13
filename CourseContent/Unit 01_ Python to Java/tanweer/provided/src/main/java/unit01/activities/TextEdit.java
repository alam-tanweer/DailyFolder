package unit01.activities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEdit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the output filename: ");
        String filename = scanner.nextLine();

        try(FileWriter fWriter = new FileWriter(filename);
            PrintWriter writer = new PrintWriter(fWriter)) {

            System.out.println("Enter text to save. Enter a blank"
                + " line to quit.");
            while(true) {
                String line = scanner.nextLine();
                if(line.equals("")) {
                    break;
                } else {
                    writer.println(line);
                }
            }
            writer.flush();
        } catch(IOException ioe) {
            System.err.println("An error occurred: " + ioe.getMessage());
        }
        scanner.close();
        System.out.println("Goodbye!");

    }
    
}
