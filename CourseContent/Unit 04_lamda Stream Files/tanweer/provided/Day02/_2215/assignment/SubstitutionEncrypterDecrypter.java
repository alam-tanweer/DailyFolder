package Day02._2215.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SubstitutionEncrypterDecrypter implements Encrypter,Decrypter {
    private final static Map<Character,Character> ENCRYPT_MAP;
    private final static Map<Character,Character> DECRYPT_MAP;
    private final static int SEED = 10;
    private final static char START_CHAR = 32;
    private final static char END_CHAR = 126;

    static {
        ENCRYPT_MAP = new HashMap<>();
        DECRYPT_MAP = new HashMap<>();
        List<Character> chars = new ArrayList<>(END_CHAR - START_CHAR + 1);
        for (char c = START_CHAR;c <= END_CHAR;++c)
            chars.add(c);
        Collections.shuffle(chars,new Random(SEED));

        for (char c = START_CHAR;c <= END_CHAR;++c) {
            ENCRYPT_MAP.put(c,chars.get(c - START_CHAR));
            DECRYPT_MAP.put(chars.get(c - START_CHAR),c);
        }
    }

    @Override
    public String decrypt(String encryptedText) {
        StringBuilder plainText = new StringBuilder();
        for (char c : encryptedText.toCharArray())
            plainText.append(DECRYPT_MAP.get(c));
        return plainText.toString();
    }

    @Override
    public String encrypt(String plainText) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : plainText.toCharArray())
            encryptedText.append(ENCRYPT_MAP.get(c));
        return encryptedText.toString();
    }
}
