package unit04;

public class TensMultiplicationTable {
    private static final int NUMBERS = 10;
    private static final int [][] TABLE = new int [NUMBERS][NUMBERS];
    static {
        for (int i = 0; i < NUMBERS; i++) {
            for (int j = 0; j < NUMBERS; j++) {
                TABLE [i][j] = (i + 1) * (j + 1);
            }
        }
    }
    
    public static int getEntry (int row, int column) {
        return TABLE [row][column];
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUMBERS; i++) {
            for (int j = 0; j < NUMBERS; j++) {
                System.out.print (String.format ("%2d ", TABLE [i][j]));
            }
            System.out.println ();
        }
    }
}
