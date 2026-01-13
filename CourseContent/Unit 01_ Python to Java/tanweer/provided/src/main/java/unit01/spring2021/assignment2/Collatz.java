package unit01.spring2021.assignment2;

import java.util.Scanner;

public class Collatz {
    public static String sequence(int n) {
        if(n < 1) {
            return "";
        } else {
            String sequence = "";
            while(n > 1) {
                sequence = sequence + n + " ";
                if(n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = 3 * n + 1;
                }
            }
            sequence += "1";
            return sequence;
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
            String sequence = sequence(n);
            System.out.println(sequence);
        }
        scanner.close();
    }
    
}
