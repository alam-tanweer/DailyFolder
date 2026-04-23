package unit13.jeopardy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueList {

    public static List<String> uniqueList(List<String> strings) {
        HashSet<String> stringSet = new HashSet<>();
        List<String> uniqueStrings = new ArrayList<>();

        for (String string : strings) {
            if (!stringSet.contains(string)) {
                uniqueStrings.add(string);
                stringSet.add(string);
            }
        }

        return uniqueStrings;
    }

    public static void main(String[] args) {
        System.out.println(uniqueList(List.of("z","a","b","a","c","b")));
    }
}
