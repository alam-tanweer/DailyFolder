package Day02._2215;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PSS {
    public interface Encrypter {
        String encrypt(String plainText);
    }

    // #1
    public class StringUtils {
        public static String transposeChars(String input) {
            char[] output = input.toCharArray();
            for (int i = 0;i < output.length-1;i +=2 ) {
                char temp = output[i];
                output[i] = output[i+1];
                output[i+1] = temp;
            }
            return new String(output);
        }
    }

    // Question 2
    public Encrypter getEncrypter() {
        return StringUtils::transposeChars;
    }

    public void encryptStrings() {
        List<String> messages = new ArrayList<>();
        messages.add("A fox");
        messages.add("It is a good day");

        Encrypter encrypter = getEncrypter();
        messages.stream().forEach(m -> System.out.println(encrypter.encrypt(m)));
        
    }

    public void question3() {
        Map<Character,Character> encryptMap = new HashMap<>();
        Map<Character,Character> decryptMap = new HashMap<>();
        List<Character> chars = new ArrayList<>();
        for (char c = 32;c <= 126;++c)
            chars.add(c);

        Collections.shuffle(chars,new Random(10));

        for (char c = 32;c <= 126;++c) {
            encryptMap.put(c,chars.get(c - 32));
            decryptMap.put(chars.get(c - 32),c);
        }

        System.out.println(encryptMap);
        System.out.println(decryptMap);
    }

    public static void main(String[] args) {
        PSS pss = new PSS();
        pss.encryptStrings();
        pss.question3();
    }
}
