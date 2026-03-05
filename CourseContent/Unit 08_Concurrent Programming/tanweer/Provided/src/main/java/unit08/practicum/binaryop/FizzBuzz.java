package unit08.practicum.binaryop;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1,100);

        stream
            .filter(n -> n % 3 == 0)
            .filter(n -> n % 5 == 0)
            .forEach(n -> System.out.println("FizzBuzz: " + n));
    }
}
