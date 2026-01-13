package unit01.spring2021.pss3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem03 {
    @SuppressWarnings("resource")
    public static int[] readSieve(String filename) {
        try {
            FileReader fReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fReader);
            
            int size = Integer.parseInt(reader.readLine());
            int[] sieve = new int[size];
            int i = 0;
            String line;
            while((line = reader.readLine()) != null) {
                for(char digit : line.toCharArray()) {
                    if(digit == '1') {
                        sieve[i] = 1;
                    } else {
                        sieve[i] = 0;
                    }
                    i++;
                }
            }

            return sieve;

        } catch(IOException ioe) {
            System.err.println("Could not read sieve: " + ioe.getMessage());
            return null;
        }
    }
    
}
