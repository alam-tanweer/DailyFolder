package unit01.activities;

import java.util.Arrays;

public class ArrayStuff {
    public static int[] squares(int n) {
        int[] squares = new int[n];

        for(int index=0; index<n; index++) {
            squares[index] = index*index;
        }

        return squares;
    }

    public static int[][] multiplicationTable(int rows, int columns) {
        int[][] table = new int[rows][columns];

        for(int row=0; row<rows; row++) {
            for(int column=0; column<columns; column++) {
                table[row][column] = (row+1)*(column+1);
            }
        }

        return table;
    }

    public static void main(String[] args) {
        int[] squares = squares(10);
        System.out.println(Arrays.toString(squares));

        int[][] table = multiplicationTable(6, 5);
        for(int[] row : table) {
            System.out.println(Arrays.toString(row));
        }
    }
}
