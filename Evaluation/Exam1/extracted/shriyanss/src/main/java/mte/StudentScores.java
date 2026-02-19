package mte;

import java.util.Scanner;

public class StudentScores {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // read the number of student scores that will be entered
    System.out.print("Enter Number of Scores: ");
    int nStudentScores = scanner.nextInt();

    // now, fill in the scores
    int[] scores = new int[nStudentScores];

    for (int i = 0; i < nStudentScores; i++) {
        System.out.println("Enter score: ");
        scores[i] = scanner.nextInt();
    }

    // use loops
    int n_passing = 0;
    int n_failing = 0;
    int n_perfect = 0;
    int score_sum_for_avg = 0;

    for (int i = 0; i < nStudentScores; i++) {
        if (scores[i] >= 60) {
            n_passing++;
            if (scores[i] == 100) {
                n_perfect++;
            }
        } else {
            n_failing++;
        }

        score_sum_for_avg += scores[i];
    }

    // go through scores and compute the values

    int highest = 0;
    int lowest = 100;
    float average = score_sum_for_avg / nStudentScores;

    for (int i = 0; i < nStudentScores; i++) {
        if (scores[i] > highest) {
            highest = scores[i];
        } else if (scores[i] < lowest) {
            lowest = scores[i];
        }
    }

    System.out.print("Scores:");
    for (int i = 0; i < nStudentScores; i++) {
        System.out.print(" " +scores[i]);
    }
    System.out.println();
    System.out.println("Highest: " + highest);
    System.out.println("Lowest: " + lowest);
    System.out.println("Average: " + average);
    System.out.println("Passing: " + n_passing);
    System.out.println("Failing: " + n_failing);
    System.out.println("Perfect: " + n_perfect);
}
}
