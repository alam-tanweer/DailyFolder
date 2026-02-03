package Day02._2215.assignment;

public class StringUtils {
    public static String transposeChars(String input) {
        char[] output = input.toCharArray();
        for (int i = 0;i < output.length-1;i+=2) {
            char temp = output[i];
            output[i] = output[i+1];
            output[i+1] = temp;
        }
        return new String(output);
    }
}