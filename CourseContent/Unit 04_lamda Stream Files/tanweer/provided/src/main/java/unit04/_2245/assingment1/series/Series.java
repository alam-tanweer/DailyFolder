package unit04._2245.assingment1.series;
import java.util.stream.Stream;

public class Series {
    private static long factorial;

    private static Stream<Double> buildSeries (int length) {
        Stream.Builder <Double> builder = Stream.builder ();
        for (double i = 1; i <= length; i++) {
            builder.add (i);
        }

        return builder.build ();
    }

    private static long factorialForEach (int num) {
        Series.factorial = 1;

        // Factorial
        Stream <Double> sequence = buildSeries (num);
        sequence.forEach ((value) -> factorial *= value);
        return Series.factorial;
    }

    private static long factorialReduce (int num) {
        Stream <Double> sequence2 = buildSeries (num);
        double result = sequence2.reduce ((x, y) -> x * y).get (); 
        return (long) result;
    }

    private static double piGregoryLeibniz (int num) {
        Stream <Double> sequence2 = buildSeries (num);
        double result = sequence2.mapToDouble (
            (x) -> (1 / ((x * 2 + 1))) * Math.pow (-1, x % 2)).sum (); 
        return (result + 1) * 4;
    }

    private static double piNilakantha (int num) {
        Stream <Double> sequence2 = buildSeries (num);
        double result = sequence2.mapToDouble ((x) -> {
            double s = x * 2;
            return (4 / (s * (s + 1) * (s + 2))) * Math.pow (-1, (x + 1) % 2);
        }).sum (); 
        return result + 3;
    }

    public static void main(String[] args) {
        int num = 20;

        // buildSeries Test
        Stream <Double> stream = buildSeries (num);
        stream.forEach ((x) -> System.out.print (x + " "));
        System.out.println ();

        // 20! for reference: 2432902008176640000

        // Factorial ForEach test
        System.out.println (num + "! = " + factorialForEach (num));

        // Factorial Reduce test
        System.out.println (num + "! = " + factorialReduce (num));


        // PI for reference: 3.141592653589793238462643
        System.out.println ("pi = " + piGregoryLeibniz (100000));

        System.out.println ("pi = " + piNilakantha (100000));
    }
}