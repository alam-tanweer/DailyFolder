package unit01.activities;

public class EuclidGCD {
    public static int gcd(int a, int b) {
        int r;
        while((r = a % b) > 0) {
            a = b;
            b = r;
        }
        return b;
    }
}
