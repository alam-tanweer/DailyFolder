package Day02._2215.assignment;

import java.util.Base64;

public class EncryptDecrypt {

    public static Encrypter getTransposeEncrypter() {
        return StringUtils::transposeChars; 
    }

    public static Decrypter getTransposeDecrypter() {
        return StringUtils::transposeChars;
    }

    public static Encrypter getBase64Encrypter() {
        return new Encrypter() {
            @Override
            public String encrypt(String plainText) {
                Base64.Encoder encoder = Base64.getEncoder();
                String encryptedText =  encoder.encodeToString(plainText.getBytes());
                return encryptedText;
            }
        };
    }

    public static Decrypter getBase64Decrypter() {
        return new Decrypter() {
            @Override
            public String decrypt(String encryptedText) {
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] bytes = decoder.decode(encryptedText);
                String plainText = new String(bytes);
                return plainText;
            }
        };
    }

    public static Encrypter getSubstitutionEncrypter() {
        return et -> new SubstitutionEncrypterDecrypter().encrypt(et);
    }

    public static Decrypter getSubstitutionDecrypter() {
        return pt -> new SubstitutionEncrypterDecrypter().decrypt(pt);
    }

    public static void EncryptDecryptTest(Encrypter encrypter,Decrypter decrypter) {
        String plainText = "You miss 100 percent of the shots you never take.";
        String encryptedText = encrypter.encrypt(plainText);
        String decodedText = decrypter.decrypt(encryptedText);
        System.out.println("Plain Text:     " + plainText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decodedText);
    }
    
    public static void main(String[] args) {
        System.out.println("\nTranspose");
        EncryptDecryptTest(getTransposeEncrypter(),getTransposeDecrypter());

        System.out.println("\nBase64");
        EncryptDecryptTest(getBase64Encrypter(),getBase64Decrypter());

        System.out.println("\nSubstitution");
        EncryptDecryptTest(getSubstitutionEncrypter(),getSubstitutionDecrypter());
    }
}
