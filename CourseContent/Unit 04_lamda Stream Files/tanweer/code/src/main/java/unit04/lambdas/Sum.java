package unit04.lambdas;

import java.util.stream.*;

public class Sum {

    static int sum = 0;
    public static int sum(int num) {

        // print values using forEach (consumer)
        IntStream.range(1, num + 1)
                 .forEach(System.out::println);

        // compute sum using sum() (consumer)
        int total = IntStream.range(1, num + 1)
                             .sum();

        return total;
    }

    public static int sum2(int num) {

        // int sum = 0; //Not allowed 
        // print values using forEach (consumer)
        IntStream.range(1, num + 1)
                 .forEach(System.out::println);

        // compute sum using sum() (consumer)
        IntStream.range(1, num + 1)
                             .forEach(i -> sum = sum + i);

        return sum;
    }

    public static int shiftedSum(int num, int shift) {

        int result =
            IntStream.rangeClosed(1, num)
                     .map(x -> x + shift)  // lambda mapper
                     .sum();               // consumer

        return result;
    }

    public static void main(String[] args) {

        int result = sum(20);
        System.out.println("Returned sum = " + result);

        int shifted = shiftedSum(5, 10);
        System.out.println("Shifted sum = " + shifted);        
    }
}
