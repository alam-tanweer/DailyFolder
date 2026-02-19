package mte;
import java.util.Scanner;

public class StudentScores {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number of student scores.");
        int amount = scanner.nextInt();
        int N = amount;

        if (N <= 100){
            int i = N;
            while(i != 100){
                int numArray = new int[i];
                i = i + 1;
            }
        }else{
            System.out.println("the number of grades must be from 0 to 100 ");
        }
    
        
    }
}