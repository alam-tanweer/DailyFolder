package unit13.jeopardy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Swapper {
    public static void main(String[] args) throws IOException{
        String file = "data/word_pairs.txt";
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            br.lines()
            .map(line -> line.split(" "))
            .map(parts -> parts[0] + " " + parts[1])
            .sorted()
            .forEach(System.out::println);
        }
    }
}
