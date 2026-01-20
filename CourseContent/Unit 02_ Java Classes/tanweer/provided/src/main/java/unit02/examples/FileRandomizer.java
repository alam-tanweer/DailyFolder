package unit02.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileRandomizer {
    public static void randomize(String inputFilename, String outputFilename) {
        try(FileReader fr = new FileReader(inputFilename);
            BufferedReader reader = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outputFilename);
            PrintWriter writer = new PrintWriter(fw)) {

            String count = reader.readLine(); // fix for count

            List<String> lines = new ArrayList<>();
            String line;
            while((line = reader.readLine()) != null) {
                lines.add(line);
            }

            Collections.shuffle(lines);

            writer.println(count); // fix for count
            for(String nextLine : lines) {
                writer.println(nextLine);
            }
                
        } catch(IOException ioe) {
            System.err.println("Error randomizing file: " + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("Usage: java FileRandomizer <input filename> " 
                + "<output filename>");
            System.exit(1);
        }

        String inputFilename = args[0];
        String outputFilename = args[1];

        randomize(inputFilename, outputFilename);
    }
    
}
