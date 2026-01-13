package unit01.spring2021.assignment1;

public class Collatz {
    public static String sequence(int n) {
        if(n < 1) {
            return "";
        } else {
            String sequence = "";
            while(n > 1) {
                sequence = sequence + n + " ";
                if(n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = 3 * n + 1;
                }
            }
            sequence += "1";
            return sequence;
        }
    }

    public static void main(String[] args) {
        System.out.println(sequence(13));
        System.out.println(sequence(1));
        System.out.println(sequence(0));
        System.out.println(sequence(5));
    }
    
}
