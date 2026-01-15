package unit01;

public class CountUp {
    public static int countWhile(int n) {
        int sum = 0;
        int current = 0;
        while (current <= n) {
            System.out.println(current);
            sum += current;
            current++;
        }
        return sum;
    }

    public static void printNbr(int n) {
        int counter = 0;
        while (counter < n) {
            counter++;
            if (counter % 2 != 0) {
                continue;
            }
            
            if (counter >= 20) {
                break;
            }

            System.out.println(counter);
        }

    }

    public static int countFor(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
            System.out.println(i);
        }
        return sum;
    }

    public static void forExample() {

        // for (int i = 0; i < 10; i++) {
        //     System.out.println(i);
        // }

        // for (int i = 0, j = 10; i < j; i++, j--) {
        //     System.out.println(i + " " + j);
        // }

        for (;;) {
            System.out.println(1);
        }        

    }

    public static void main(String[] args) {
        // int sum = countWhile(10);
        // System.out.println("sum: " + sum);

        // int sum = countFor(10);
        // System.out.println("sum: " + sum);

        // printNbr(25);
        forExample();
    }

}
