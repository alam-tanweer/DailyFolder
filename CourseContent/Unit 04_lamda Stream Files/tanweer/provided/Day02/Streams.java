package Day02;

import java.util.ArrayList;
import java.util.List;

public class Streams {
    static int sum = 0;

    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<>();
        grades.add (54);
        grades.add (85);
        grades.add (97);
        grades.add (72);

        grades.stream().forEach (e -> sum += e);
        grades.stream().forEach (System.out::println);
        System.out.println ("Sum = " + sum);

        // Print only passing grades
        grades.stream().filter(e -> e > 69).forEach(System.out::println);
    }
}
