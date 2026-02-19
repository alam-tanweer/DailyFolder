package mte.midterm;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;


public class StudentScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number greater than 0: ");
        int input = scanner.nextInt();
        scanner.nextLine();
        int[] scores = new int[input];

        for(int i=0; i<input;i++){
            scores[i] = scanner.nextInt(); 
                scanner.nextLine();}

        Arrays.stream(scores).forEach(System.out::println);
        int passing =0;
        int failing =0;
        int perfect =0;
        int max = -1;
        int low = 103;
        for (int i: scores){
            if(i>max) max=i;
            if (i<low) low=i;
            if(i>=60) passing++;
            if(i<60) failing++;
            if(i==100) perfect++;
        }
        System.out.println("Highest: "+max);
        System.out.println("Lowest: "+low);
        System.out.println("Passed: "+passing);
        System.out.println("Failed: "+failing);
        System.out.println("Perfect: "+perfect);
        System.out.println("Average: "+Arrays.stream(scores).average().getAsDouble()); //I know we didn't use this in class but we used streams and this is not far fetched
    }
}
