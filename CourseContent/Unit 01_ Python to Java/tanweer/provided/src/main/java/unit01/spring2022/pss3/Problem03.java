package unit01.spring2022.pss3;

import static unit01.spring2022.pss3.Problem02.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem03 {
    public static void main(String[] args) {
        try(FileInputStream fin = new FileInputStream("data/digits.txt");
            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader reader = new BufferedReader(ir)) {
            
            String baseString = reader.readLine();
            int base  = Integer.valueOf(baseString);

            String number = reader.readLine();
            while(number != null) {
                int value = stringToInt(number, base);

                System.out.println(value);
                number = reader.readLine();
            }

        } catch(IOException ioe) {
            System.out.println("File does not exist.");
        }
    }
}
