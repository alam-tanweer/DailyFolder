package mte;
import java.util.Arrays;
import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter number of student scores: ");
        int scoreNum = scanner.nextInt();

        int[] scores = new int[scoreNum];
        for(int i = 0; i < scores.length; i++){
            System.out.print("enter student score(0-100): ");
            int score = scanner.nextInt();
            scores[i] = score;
        }

        int perfectScore = 0;
        int passing = 0;
        int failing = 0;
        int highest = 0;
        int lowest = 100;
        double average = 0;

        for(int i = 0; i < scores.length; i++){
            average += scores[i];

            if(scores[i] == 100){
                perfectScore ++;
                passing ++;
                highest = 100;
            }else if(scores[i] >= 60){
                passing ++;
            }else{
                failing ++;
            }

            if(scores[i] < lowest){
                lowest = scores[i];
            }

            if(scores[i] > highest){
                highest = scores[i];
            }
        }
        average /= scores.length;

        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Average: " + average);
        System.out.println("Passing: " + passing);
        System.out.println("Failing: " + failing);
        System.out.println("Perfect: " + perfectScore);
    }
}
