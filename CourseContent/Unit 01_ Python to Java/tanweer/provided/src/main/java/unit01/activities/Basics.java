package unit01.activities;

public class Basics {
    /**
     * 1.2.2 - print multiples of 3 and 7 (challenge: but not both)
     * @param args Command line arguments. Ignored.
     */
    public static void main(String[] args) {
        for(int i=1; i<=100; i++) {
            if(i % 3 == 0 && i % 7 != 0) { // challenge
                System.out.println(i);
            } else if(i % 7 == 0 && i % 3 != 0) { // challenge
                System.out.println(i);
            }
        }
    }
}
