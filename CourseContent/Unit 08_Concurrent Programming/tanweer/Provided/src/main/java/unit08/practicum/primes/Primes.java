package unit08.practicum.primes;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
            
        for (int i = 2;i < n;++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int intCount = 50;
        List<Integer> ints = new ArrayList<>(intCount);
        for (int i = 1;i <= intCount;++i) {
            ints.add(i);
        }

        ints.stream().filter(Primes::isPrime).forEach(System.out::println);
        //or
        ints.stream().filter(n -> isPrime(n)).forEach(n -> System.out.println(n));
    }
    
}
