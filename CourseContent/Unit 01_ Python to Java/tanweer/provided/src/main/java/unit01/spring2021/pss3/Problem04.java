package unit01.spring2021.pss3;

public class Problem04 {
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
    
}
