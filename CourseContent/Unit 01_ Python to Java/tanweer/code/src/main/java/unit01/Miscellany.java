package unit01;

import java.io.File;
import java.util.Arrays;

public class Miscellany {

    @SuppressWarnings("unused")
    public static void helpfulCodeForSlides() {
        // helpful code
        String string = "this is a string";
        int length = string.length();
        char c = string.charAt(3);
        String cat = "abc" + "def";

        for(int i=5; i<11; i++) {
            System.out.println(i);
        }

        int[] numbers = new int[5];

        numbers[0] = 2;
        numbers[1] = 3;
        numbers[2] = 5;
        numbers[3] = 7;
        numbers[4] = 11;

        int x = numbers[3];

        for(int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // 5 rows, 4 columns
        int[][] table = new int[5][4];

        // row 1
        int[] oneRow = table[1];
        // the value at row 3 column 2
        int singleValue = table[3][2];

        for(int row=0; row<table.length; row++) {
            for(int col=0; col < table[row].length; col++) {
                System.out.println(table[row][col]);
            }
        }

        File file = new File("some_file.txt");
        String name = file.getName();
        boolean exists = file.exists();
    }

    public static String reverseChars(String string) {
        String reversed = "";
        for(int i=0; i<string.length(); i++) {
            reversed = string.charAt(i) + reversed;
        }
        return reversed;
    }
    
    

    // removed and replaced with the above problem (too hard)
    // public static boolean isPalindrome(String string) {
    //     int i=0;
    //     int j=string.length() - 1;
    //     while(i < j) {
    //         if(string.charAt(i) != string.charAt(j)) {
    //             return false;
    //         } else {
    //             i++;
    //             j--;
    //         }
    //     }

    //     return true;
    // }

    public static int[] reversal(int[] array) {
        int[] reversed = new int[array.length];

        for(int i=0; i<array.length; i++) {
            reversed[i] = array[array.length-1-i];
        }

        return reversed;
    }

    // 1.3.3
    public static int[] squares(int n) {
        int[] array = new int[n];
        for(int i=0; i<array.length; i++) {
            array[i] = i * i;
        }
        return array;
    }

    public static int[][] multiplicationTable(int rows, int columns) {
        int[][] table = new int[rows][columns];

        for(int row=0; row<rows; row++) {
            for(int column=0; column<columns; column++) {
                table[row][column] = (row+1) * (column+1);
            }
        }

        return table;
    }

    public static void main(String[] args) {
        int[] data = squares(10);
        System.out.println(Arrays.toString(data));
        int[][] multTable = multiplicationTable(5, 5);
        for (int[] is : multTable) {
            System.out.println(Arrays.toString(is));
        }
        

    }
    
}
