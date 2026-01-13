package unit01.spring2021.pss3;

import java.util.Scanner;

public class Primes {
    public static boolean isPrime(int n) {
        if(n < 2) { // any number less than 2 is not prime
            return false;
        } else if(n == 2) { // 2 is prime
            return true;
        } else if(n % 2 == 0) { // any even number > 2 is not prime
            return false;
        } else {
            for(int i=3; i*i<=n; i+= 2) { // loop can stop when i > the square
                if(n % i == 0) {          // root of n
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Enter a natural number: ");
            int n = scanner.nextInt();
            if(n < 1) {
                break;
            }
            if(isPrime(n)) {
                System.out.println(n + " is prime.");
            } else {
                System.out.println(n + " is NOT prime.");
            }
        }
        scanner.close();
    }
    
}
