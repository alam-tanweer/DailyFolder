package unit01.spring2022.assignment3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DigitFileMaker {
    private static final Random RNG = new Random(1);

    public static void makeDigitsFile(int base, boolean bigEndian, 
        int count) throws IOException {

        String name = "data/digits_" + base + "_" 
            + (bigEndian ? "big" : "little") + ".txt";
        try(FileOutputStream out = new FileOutputStream(name);
            PrintWriter writer = new PrintWriter(out)) {

            writer.println(base);
            writer.println(bigEndian ? "big-endian" : "little-endian");

            for(int i=0; i<count; i++) {
                int value = RNG.nextInt(1000000);
                String stringValue = Integer.toString(value, base);

                if(!bigEndian) {
                    stringValue = reverse(stringValue);
                }

                writer.println(stringValue + " " + value);
            }
        }
    }

    private static String reverse(String string) {
        StringBuilder builder = new StringBuilder();
        for(int i=string.length()-1; i>=0; i--) {
            builder.append(string.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        makeDigitsFile(10, true, 10);
        makeDigitsFile(10, false, 10);
        makeDigitsFile(8, true, 10);
        makeDigitsFile(8, false, 10);
        makeDigitsFile(2, true, 10);
        makeDigitsFile(2, false, 10);
    }
}
