package unit05.assignment2.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class IterableReader implements Iterable<String>, Iterator<String>, AutoCloseable {
    private FileReader fileReader;
    private BufferedReader br;
    private boolean hasNextLine;
    private String nextLine;

    public IterableReader(String filename) throws IOException {
        fileReader = new FileReader(filename);
        br = new BufferedReader(fileReader);
        nextLine = br.readLine();
        if (nextLine == null) {
            hasNextLine = false;
        } else {
            hasNextLine = true;
        }
    }

    public Iterator<String> iterator() {
        return this;
    }

    public void close() throws IOException {
        fileReader.close();
        br.close();
    }

    @Override
    public String next() {
        String toReturn = nextLine;
        try {
            nextLine = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Can't read the next line!");
            hasNextLine = false;
            return null;
        }
        if (nextLine == null) {
            hasNextLine = false;
        }
        return toReturn;
    }

    @Override
    public boolean hasNext() {
        return hasNextLine;
    }

    public static void main(String[] args) throws IOException {
        try (IterableReader reader = new IterableReader("data/simple.txt");) {
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader("data/simple.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
