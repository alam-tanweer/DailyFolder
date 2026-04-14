package unit13;

public class Euclid {
    public static int gcd(int a, int b) {
        while(a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    /*
     * Dropped this for time.
    public static double distance(int[] a, int[] b) {
        double sum = 0.0;
        for(int i=0; i<a.length; i++) {
            double diff = a[i] - b[i];
            sum += (diff * diff);
        }
        return Math.pow(sum, 0.5);
    }
    */

    public static void main(String[] args) {
        // System.out.println(gcd(1071, 462));
        System.out.println("Value is : " + gcd(1071, 460));

        // cut for time
        // int[] a = {9, 7, 5, 1};
        // int[] b = {1, 3, 5, 7};
        // System.out.println(distance(a, b));
    }
}
