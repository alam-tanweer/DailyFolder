package unit04.lambdas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEdit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter output filename: ");
            String filename = scanner.nextLine().trim();

            // Create FileWriter and PrintWriter (try-with-resources auto-closes them)
            try (FileWriter fw = new FileWriter(filename);
                 PrintWriter writer = new PrintWriter(fw)) {

                System.out.println("Type lines to save to the file. Enter a blank line to finish.");

                while (true) {
                    String line = scanner.nextLine();

                    // Stop if the user enters a blank line
                    if (line.isBlank()) {
                        break;
                    }

                    writer.println(line);
                }

                writer.flush();
                System.out.println("Saved text to: " + filename);
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
