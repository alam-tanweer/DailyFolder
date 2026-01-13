package unit01.spring2022.pss2;

public class Problem04 { // Fib

    public static int fib(int n) {
        if(n < 1) {
            return -1;
        } else {
            int fn_1 = 1;
            int fn_2 = 0;

            while(n > 2) {
                int temp = fn_1;
                fn_1 = fn_2 + fn_1;
                fn_2 = temp;
                n -= 1;
            }

            if(n == 1) {
                return fn_2;
            } else {
                return fn_1;
            }
        }
    }
}
