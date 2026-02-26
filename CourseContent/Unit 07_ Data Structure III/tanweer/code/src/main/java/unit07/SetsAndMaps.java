package unit07;

import java.util.*;

public class SetsAndMaps {

    public static void addAndPrint(Set<String> set) {

        set.add("aardvark");
        set.add("Zoo");
        set.add("Monkey");
        set.add("zebra");
        set.add("shark");
        set.add("Lion");

        // Print elements using for-each
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("------------------------");
    }

    public static void putAndPrint(Map<String, Integer> map) {

        map.put("aardvark", 1);
        map.put("Zoo", 2);
        map.put("Monkey", 3);
        map.put("zebra", 4);
        map.put("shark", 5);
        map.put("Lion", 6);

        // Iterate over keys and print
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.println("------------------------");
    }    

    public static void main(String[] args) {

        // Call with HashSet
        addAndPrint(new HashSet<String>());

        Comparator comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Convert both to lowercase before comparing
                return s1.toLowerCase().compareTo(s2.toLowerCase());
            }
        };
        // Call with TreeSet
        addAndPrint(new TreeSet<String>(comp));

        putAndPrint(new HashMap<>());

        putAndPrint(new TreeMap<>(comp));

    }
}