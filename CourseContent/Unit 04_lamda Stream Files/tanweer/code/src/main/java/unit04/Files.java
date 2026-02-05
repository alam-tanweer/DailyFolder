package unit04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Files {
    public static void info(String filename) {

        File file = new File(filename);

        System.out.println("Name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());

        if (file.exists()) {
            System.out.println("Length: " + file.length() + " bytes");
        }

        System.out.println("----------------------");
    }

    public static void printFile(String filename) {

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            br.lines()
                    .forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void printFile1(String filename) {

        try (FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr)) {

            br.lines()
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void printFile2(String filename) {

        // putting file creation in try would auto close the file when done even if
        // there is error.
        try (FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr)) {

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

            // br.close();
            // fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        info("data/alice.txt"); // existing file
        // info("missing.txt"); // non-existing file
        // info("."); // current directory

        // printFile("data/alice.txt");
        printFile2("data/alice.txt");

    }
}
