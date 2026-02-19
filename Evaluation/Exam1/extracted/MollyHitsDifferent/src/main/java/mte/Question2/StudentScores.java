package mte.Question2;

import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Scores");
        byte n = scanner.nextByte();
        scanner.nextLine();
        
        byte[] scoreArray = new byte[n];
        byte counter = 0;
        while (counter < n){
            System.out.println("Please type an interger between 0 and 100: ");
            byte holder = scanner.nextByte();
            scanner.nextLine();
            scoreArray[counter] = holder;
            counter++ ;
            }
            System.out.println("Scores in order of entry ");
            for (byte i = 0 ; i < scoreArray.length; i++ )
                {System.out.print(scoreArray[i] + " ");}
            System.out.println();
        counter = 0;
        byte highNum = 0;
        while(counter < scoreArray.length){
        if (scoreArray[counter] > highNum) {highNum = scoreArray[counter];}
        counter++; }
        System.out.println("Highest Score in Class is " + highNum );
        
        counter = 0;
        byte lowest = scoreArray[counter];
        while(counter < scoreArray.length){
        if (scoreArray[counter] < lowest ) {lowest = scoreArray[counter];}
        counter++; }
        System.out.println("Lowest Score in class is " + lowest);

        counter = 0;
        byte passing = 0 ;
        while(counter < scoreArray.length){
        if (scoreArray[counter] > 60 ) {passing++;}
        counter++;}
            System.out.println("Number of students passing " + passing);
        
        counter = 0;
        byte failing = 0 ;
        while(counter < scoreArray.length){
        if (scoreArray[counter] < 60 ) {failing++;}
        counter++;}
            System.out.println("Number of students who failed " + failing);
        
        counter = 0;
        int aggregator = 0;
        while(counter < scoreArray.length){ 
            aggregator += scoreArray[counter]; 
            counter++;
        }
        System.out.println("Average score = " + (aggregator/scoreArray.length));

        byte perfect = 0;
        counter = 0;
        while (counter < scoreArray.length){
            if (scoreArray[counter] == 100){perfect++;}
        counter++;
        } 
        System.out.println("Number of perfect scores: " + perfect);
        }
    }

