package unit01.spring2022.assignment3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Base10Converter {
    public static int charToInteger(char digit) {
        return (int)digit - 48;
    }


    public static int arrayToInteger(char[] digits, int base, 
        boolean bigEndian) {

        int value = 0;
        int power = bigEndian ? digits.length - 1 : 0;
        int step = bigEndian ? -1 : 1;

        for(int i=0; i<digits.length; i++) {
            int digit = charToInteger(digits[i]);
            int raiseBase = (int)Math.pow(base, power);
            power += step;
            int digitValue = digit * raiseBase;
            value += digitValue;
        }

        return value;
    }

    public static void main(String[] args) {
        System.out.println(arrayToInteger("10101".toCharArray(), 2, true));
        System.out.println(arrayToInteger("11001".toCharArray(), 2, true));
        System.out.println(arrayToInteger("1234".toCharArray(), 4, true));
        System.out.println(arrayToInteger("4330".toCharArray(), 4, true));
        System.out.println(arrayToInteger("5467".toCharArray(), 8, true));
        System.out.println(arrayToInteger("1024".toCharArray(), 8, true));
        // System.out.println(arrayToInteger("7987".toCharArray(), 16, true));
        // System.out.println(arrayToInteger("AF23".toCharArray(), 16, true));
        System.out.println("**********");
        System.out.println(arrayToInteger("10101".toCharArray(), 2, false));
        System.out.println(arrayToInteger("11001".toCharArray(), 2, false));
        System.out.println(arrayToInteger("1234".toCharArray(), 4, false));
        System.out.println(arrayToInteger("4330".toCharArray(), 4, false));
        System.out.println(arrayToInteger("5467".toCharArray(), 8, false));
        System.out.println(arrayToInteger("1024".toCharArray(), 8, false));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String filename = scanner.nextLine();

        try(FileInputStream fin = new FileInputStream(filename);
            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader reader = new BufferedReader(ir)) {
            
            String baseString = reader.readLine();
            int base  = Integer.valueOf(baseString);

            String endianness = reader.readLine();
            boolean bigEndian = endianness.equals("big-endian");

            System.out.println("base: " + base);
            System.out.println("endianness: " + endianness);

            String line = reader.readLine();
            while(line != null) {
                String[] tokens = line.split(" ");
                char[] digits = tokens[0].toCharArray();
                int decimal = Integer.valueOf(tokens[1]);
                int value = arrayToInteger(digits, base, bigEndian);

                System.out.println(tokens[0] + ": " + value + " ("
                    + (value == decimal ? "match" : "mismatch " + decimal) + ")" );
                line = reader.readLine();
            }

        } catch(IOException ioe) {
            System.out.println("File does not exist: " + filename);
        }

        scanner.close();
    }
}
