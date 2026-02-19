package mte;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {
        System.out.println("Enter Number of Scores: ");
        Scanner scanner = new Scanner(System.in);
        
        int scores = scanner.nextInt();
        System.out.println(scores);
        int passing =0;
        int failing =0;
        int perfect =0;
        int lowest = 100;
        int highest = 0;
        double average = 0;
        int[] array = new int[scores];
        
        if(scores > 0){
            

            for(int i=0;i<scores;i++){
                
                System.out.println("Enter Students Score: ");
                int score = scanner.nextInt();
                array[i] = score;
                
                //if(score > 0 && score >101){
                //System.out.println(score);
                
                //Lowest and highest 
                if(score > highest){
                    highest = score;
                }
                if(score < lowest ){
                    lowest = score;
                }

                //Track number of failing, passing and perfect 
                if(score >= 60){passing +=1;}
                if(score < 60){failing +=1;}
                if(score == 100){perfect +=1;}
                //Lowest, Highest & Average scrores
                average += score;
                
                

            //}
            
            


            }
            average /= scores;
            scanner.close();
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Average: " + average);
        System.out.println(" Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Passing: " + passing + " Failing: " + failing + " Perfect: " + perfect);


    }
    
}
