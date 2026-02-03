package unit04.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mailer {

    /**
     * Example of using records to store data read from a CSV file. It's an elegant
     * and concise way to represent a data structure with multiple fields. However,
     * we dont currently cover it in the course. Possible future enhancement.
     */
    public record Data (String ssn, String name, String affiliation, String address) {}

    public static void usingRecords() throws IOException{
        String affiliation = "Democrat";
        try (BufferedReader br = new BufferedReader(new FileReader("data/nyc_voter_records.csv"));
             PrintWriter pw = new PrintWriter("data/" + affiliation + "_records.csv")) {
                pw.println("Name,Address");
                br.lines()
                .map(line ->  {
                    String[] parts = line.split(",", 4);
                    return new Data (parts[0], parts[1], parts[2], parts[3]);
                })
                .filter(value -> value.affiliation().equals (affiliation))
                .sorted((a, b) -> a.name().split(" ")[1].compareTo(b.name().split(" ")[1]))
                .forEach(value -> pw.println (value.name() + "," + value.address()));
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the affiliation to filter by: ");
        String affiliation = scanner.nextLine();
        scanner.close();

        try (BufferedReader br = new BufferedReader(new FileReader("data/nyc_voter_records.csv"));
             PrintWriter pw = new PrintWriter("data/" + affiliation + "_records.csv")) {
                
                // Add a header line (not part of the assignment but good practice)
                pw.println("Name,Address");

                // Get lines from the file as a stream.
                br.lines()

                // Split the line into parts (max 4 parts to avoid splitting the address)
                .map(line ->  line.split(",", 4))

                // Filter by the requested affiliation
                .filter(value -> value[2].equals (affiliation))

                // Sort by last name (assumed to be the second word in the name field)
                .sorted((a, b) -> a[1].split(" ")[1].compareTo(b[1].split(" ")[1]))

                // Write the name and address to the output file
                .forEach(value -> pw.println (value[1] + "," + value[3]));
        }
    }
}
    