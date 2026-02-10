package practicum01;

import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter total score count: ");
        // Part 1: read N
        int N = scanner.nextInt();

        // Part 2: create array and read scores
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }

        // Part 3 + 4: analyze scores
        int passing = 0;
        int failing = 0;
        int perfect = 0;

        int highest = scores[0];
        int lowest = scores[0];
        int sum = 0;

        for (int score : scores) {

            sum += score;

            if (score >= 60) passing++;
            else failing++;

            if (score == 100) perfect++;

            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }

        double average = (double) sum / N;

        // print scores
        System.out.print("Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Average: " + average);
        System.out.println("Passing: " + passing);
        System.out.println("Failing: " + failing);
        System.out.println("Perfect: " + perfect);

        scanner.close();
    }
}

