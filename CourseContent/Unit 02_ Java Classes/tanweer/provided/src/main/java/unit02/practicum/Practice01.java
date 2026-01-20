package unit02.practicum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Practice01 {
    public static String arrayToString(int[] array) {
        String string = "[";

        if(array.length > 0) {
            string += array[0];
            for(int i=1; i<array.length; i++) {
                string = string + ", " + array[i];
            }
        }

        string += "]";
        return string;
    }

    public static int printLines(String filename, String letter) {
        int linesPrinted = 0;
        try(FileReader fReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fReader)) {
            String lowerLetter = letter.toLowerCase();
            String line;
            while((line = reader.readLine()) != null) {
                if(line.length() > 0 && 
                   line.toLowerCase().charAt(0) == lowerLetter.charAt(0)) {
                    System.out.println(line);
                    linesPrinted++;
                }
            }

        } catch(IOException e) {
            System.err.println("There was an error reading the file.");
        }
        return linesPrinted;
    }

    public static void main(String[] args) {
        // expected main
        int linesPrinted = printLines("data/alice.txt", "y");
        System.out.println("Printed " + linesPrinted + " lines...");

        // truth table
        Map<Character,Integer> counts = new HashMap<>();
        for(char c='a'; c<='z'; c++) {
            int count = printLines("data/alice.txt", "" + c);
            counts.put(c, count);
        }

        System.out.println(counts.size());

        for(char c='a'; c<='z'; c++) {
            System.out.println(c + ":" + counts.get(c));
        }
    }
}