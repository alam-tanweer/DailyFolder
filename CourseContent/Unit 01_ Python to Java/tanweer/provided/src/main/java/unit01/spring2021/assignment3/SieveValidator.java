package unit01.spring2021.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SieveValidator {

    public static int[] readSieve(String filename) {
        try(FileReader fReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fReader)) {
            
            int size = Integer.parseInt(reader.readLine());
            int[] sieve = new int[size];
            int i = 0;
            String line;
            while((line = reader.readLine()) != null) {
                for(char digit : line.toCharArray()) {
                    sieve[i] = digit == '1' ? 1 : 0;
                    i++;
                }
            }
            return sieve;

        } catch(IOException ioe) {
            System.err.println("Could not read sieve: " + ioe.getMessage());
            return null;
        }
    }

    public static int repairSieve(int[] sieve) {
        System.out.println("Validating sieve of size " + sieve.length 
            + "...");
        int errors = 0;
        for(int n=0; n<sieve.length; n++) {
            if(sieve[n] == 0 && !Primes.isPrime(n)) {
                System.out.println("  " + n 
                    + " is incorrectly marked as prime.");
                sieve[n] = 1;
                errors += 1;
            } else if(sieve[n] == 1 && Primes.isPrime(n)) {
                System.out.println("  " + n 
                    + " is incorrectly marked as NOT prime.");
                sieve[n] = 0;
                errors += 1;
            }
        }
        System.out.println("  Sieve contained " + errors + " error(s).");
        System.out.println();
        return errors;
    }
    public static void main(String[] args) {
        File dir = new File("data");
        for(File file : dir.listFiles()) {
            String name = file.getName();
            if(name.startsWith("sieve")) {
                int[] sieve = readSieve(file.getAbsolutePath());
                repairSieve(sieve);
            }
        }
    }
}
