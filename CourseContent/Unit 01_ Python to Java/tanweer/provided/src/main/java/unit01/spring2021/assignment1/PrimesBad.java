package unit01.spring2021.assignment1;

public class PrimesBad {
    private static boolean isPrimeBad(int n) {
        if(n == 1) {
            return false;
        } else if(n == 2) {
            return true;
        } else if(n % 2 == 0) {
            return false;
        } else if(n % 3 == 0 && n != 3) {
            return false;
        } else if(n % 5 == 0 && n != 5) {
            return false;
        } else if(n % 7 == 0 && n != 7) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int count = 0;
        for(int n=1; n<1000; n++) {
            boolean isPrime = Primes.isPrime(n);
            boolean isPrimeBad = isPrimeBad(n);
            if(isPrime != isPrimeBad) {
                count++;
                System.out.println("disagreement: " + n);
                System.out.println("  isPrime: " + isPrime);
                System.out.println("  isPrimeBad: " + isPrimeBad);
            }
        }
        System.out.println("Total disagreements: " + count);
    }
}
