package mte;

import java.util.Arrays;
import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of student scores to be entered: ");
        int n = sc.nextInt();
        sc.nextLine();
        int[] scores = new int[n];
        for(int i = 0; i < scores.length; i++){
            System.out.print("Enter a score: ");
            scores[i]=sc.nextInt();
            sc.nextLine();
        }
        int numPassing = 0;
        int numFailing = 0;
        int numPerfect = 0;
        int highest = scores[0];
        int lowest = scores[0];
        double average = 0;
        for(int i = 0; i < scores.length; i++){
            if(scores[i] >= 60){
                numPassing++;
            }
            if(scores[i] < 60){
                numFailing++;
            }
            if(scores[i] == 100){
                numPerfect++;
            }
            if(scores[i] > highest){
                highest = scores[i];
            }
            if(scores[i]<lowest){
                lowest = scores[i];
            }
            average+=scores[i];
        }
        average /= scores.length;
        System.out.println("Scores: " + Arrays.toString(scores) + "\nHighest Score: " + highest + "\nLowest Score:" + lowest + "\nAverage Score: " + average + 
                            "\nPassing: " + numPassing + "\nFailing: " + numFailing + "\nPerfect: " + numPerfect);
        sc.close();
    }
}
