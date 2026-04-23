package unit13;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileIO {
    
    public static void main(String[] args) {
        String filename = "data/alice.txt";
        try (BufferedReader file = new BufferedReader (new FileReader (filename))) {
            String line = "";
            while ((line = file.readLine()) != null) {
                System.out.println (line);
            }
        } catch (Exception e) {
            //TO DO: handle exception
        }
    }
}
