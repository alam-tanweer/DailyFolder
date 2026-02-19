package mte;

import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of scores: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int highest = 0;
        int lowest = 2000;
        int average = 0;
        int passing = 0;
        int failing = 0;
        int perfect = 0;
        String scores = "";

        for (int i = 0; i < arr.length; i ++){
            System.out.println("Enter grade:");
            int a = sc.nextInt();
            arr[i] = a;
            if (a > highest){
                highest = a;
            }
            if (a < lowest){
                lowest = a;
            }
            if (a >= 60){
                passing += 1;
            }
            if (a < 60){
                failing += 1;
            }
            
            if (a >= 100){
                perfect += 1;
            }
            average += a;
            scores += arr[i] + " ";
        }
        average = average/n;
        System.out.println("Scores: " + scores);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Average: " + average);
        System.out.println("Passing: " + passing);
        System.out.println("Failing: " + failing);
        System.out.println("Perfect: " + perfect);
        sc.close();

    }
}
