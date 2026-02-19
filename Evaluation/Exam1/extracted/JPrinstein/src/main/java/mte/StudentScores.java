package mte;

import java.util.Scanner;
import java.util.Arrays;
public class StudentScores {
    public static void main(String[] args) {

        int passing = 0;
        int failing = 0;
        int perfect = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students: ");

        int n = scanner.nextInt();
        scanner.nextLine();

        int[] scores = new int[n];

        for(int i = 0; i<n; i++){
            System.out.println("\n" + "Enter the next score: ");

            scores[i] = scanner.nextInt();
            scanner.nextLine();
        }

        //Im assuming Part C wanted a separate loop from the one above

        int highest = 0;
        int lowest = 100;
        int average = 0;

        System.out.println("\nAll Scores: ");
        for(int i=0;i<n;i++){
            System.out.println(scores[i]);
            if(scores[i] == 100){
                perfect++;
                passing++;
            }
            else if(scores[i] >= 60){
                passing++;
            }
            else{
                failing++;
            }

            if(scores[i] > highest){
                highest = scores[i];
            }
            if(scores[i] < lowest){
                lowest = scores[i];
            }

            average += scores[i];

        }

        System.out.println("\nHighest: " + highest + "\nLowest: " + lowest + "\nAverage: " + (average/n) + "\n# of Passing: " + passing + "\n# of Failing: " + failing + "\n# of Perfect: " + perfect);

    }
}
