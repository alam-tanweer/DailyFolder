package mte;

import java.util.Scanner;


public class StudentScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer:  ");
        int N = scanner.nextInt();

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter score:  ");
            scores[i] = scanner.nextInt();
        }

        int passing = 0;
        int failing = 0;
        int perfect = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) { passing+=1; }
            if (scores[i] < 60) { failing+=1; }
            if (scores[i] == 100) { perfect +=1; }
        }

        int highScore = -1;
        int lowScore = 99999;
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > highScore) { highScore = scores[i]; }
            if (scores[i] < lowScore) { lowScore = scores[i]; }
            total += scores[i];
        }
        double avgScore = (total / scores.length);

        scanner.close();

        System.out.println("Scores: \n" + scores.toString()
         + "\nHighest Score = " + highScore
         + "\nLowest Score = " + lowScore
         + "\nAverage Score = " + avgScore
         + "\nPassing: " + passing
         + "\nFailing: " + failing
         + "\nPerfect: " + perfect);
    }
}
