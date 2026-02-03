package Day02._2215.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileEncrypterDecrypter {
    public static List<String> getLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try(FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr)) {

            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line); 
        } 
        return lines;
    }

    public static void main(String[] args) throws IOException {
        
        System.out.println("Transpose Encrypt:");
        List<String> lines = getLines("Day02/_2215/assignment/data/alice_small.txt");
        lines.stream().forEach(s -> System.out.println(EncryptDecrypt.getTransposeEncrypter().encrypt(s)));

        System.out.println("\nBase64 Decrypt:");
        lines = getLines("Day02/_2215/assignment/data/alice_small_base64.txt");
        lines.stream().filter(s -> s.length() > 0).forEach(s -> System.out.println(EncryptDecrypt.getBase64Decrypter().decrypt(s)));
        
        System.out.println("\nTranspose Decrypt:");
        lines = getLines("Day02/_2215/assignment/data/alice_small_transpose.txt");
        lines.stream().filter(s -> s.length() > 0).forEach(s -> System.out.println(EncryptDecrypt.getTransposeDecrypter().decrypt(s)));
    }
}
