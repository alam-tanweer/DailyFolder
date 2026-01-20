package unit02.examples;

public class Summer {
    
    public static int TOTAL_SUM = 0;

    public static int natSum(int n) {
        if(n <= 0) {
            return 0;
        } else {
            int sum = 0;
            while(n > 0) {
                sum += n;
                n = n - 1;
            }
            TOTAL_SUM += sum;
            return sum;
        }
    }
}
    