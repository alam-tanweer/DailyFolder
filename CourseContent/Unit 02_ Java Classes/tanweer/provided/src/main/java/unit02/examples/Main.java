package unit02.examples;

import java.util.Arrays;

public class Main {
    public static void stringParsingExample() {
        String parseMe = "\t  The.Quick.Brown.Fox\n";
        String trimmed = parseMe.trim();
        String[] tokens = trimmed.split("[.]");
        System.out.println(Arrays.toString(tokens));
    }

    // miscellaneous slide example code
    public Object objectCode(Object obj) {
        String s = "\t\tabcdefg" + obj;
        Object o = s + s;
        String x = (String)o;
        return x.trim(); 
    }
}
