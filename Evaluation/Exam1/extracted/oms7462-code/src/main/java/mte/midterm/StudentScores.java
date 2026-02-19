package mte.midterm;
import java.util.Scanner;
import java.util.Arrays;

public class StudentScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer > 0: ");
        int N = scanner.nextInt();
        

        int[] array = new int[N];

        for (int index =0; index < array.length; index++){
            System.out.println("Enter a student's score between 0-100: ");
            int score = scanner.nextInt();
            array[index] = score;
        }
        int passing = 0;
        int failing = 0;
        int perfect = 0;


        
        for (int index =0; index < array.length; index++){
            if(array[index] == 100){
                perfect++;
                passing++;

            }
            else if(array[index] >= 60){
                passing++;
            }
            else {
                failing++;
            }
        }

            int highest = array[0];
            for (int index2 =0; index2 < array.length; index2++){
                if (array[index2] > highest){
                    highest = array[index2];
                }
            }

            int lowest = array[0];
            for (int index3 =0; index3 < array.length; index3++){
                if (array[index3] < lowest){
                    lowest = array[index3];
                }
            }

            int total = 0;
            for (int index4 =0; index4 < array.length; index4++){
                total += array[index4];
                }
                double average = total/N;
            

        System.out.println(passing);



        // print all scores entered
        System.out.println(Arrays.toString(array));

        // print highest score
        System.out.println("highest score: " + highest);
        // print lowest score
        System.out.println("lowest score: " + lowest);

        //print average score
        System.out.println("average score: " + average);
        //print num passing, failing, perfect
        System.out.println("perfect scores: " + perfect);
        System.out.println("passing scores: " + passing);
        System.out.println("failing scores: " + failing);


        
    }
    




    
}
