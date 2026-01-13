package unit01.spring2022.pss2;

public class Log {

    public static int log(int base, int n) {
        if(n < 0) {
            return -1;
        } else {
            int count = 0;
            
            while(n >= base) {
                n = n / base;
                count++;
            }
            return count;
        }
    }

    
}
