package unit01.activities;

public class CountUp {
    public static int countWhile(int n) {
        int sum = 0;
        int current = 0;
        while(current <= n) {
            System.out.println(current);
            sum += current;
            current++;
        }
        return sum;
    }

    public static int countFor(int n) {
        int sum = 0;
        for(int i=0; i<=n; i++) {
            sum += i;
            System.out.println(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        // int sum = countWhile(10);
        // System.out.println("sum: " + sum);
        int sum = countFor(10);
        System.out.println("sum: " + sum);
    }
    
}
