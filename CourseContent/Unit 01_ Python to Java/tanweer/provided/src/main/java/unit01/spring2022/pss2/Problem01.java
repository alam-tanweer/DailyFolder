package unit01.spring2022.pss2;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while(n >= 0) {
            System.out.print("enter an integer: ");
            n = scanner.nextInt();
            System.out.println(n);
        }
        scanner.close();
    }
}
