package unit07.starter;

import java.util.*;

public class SetsAndMaps {

    public static void addAndPrint(java.util.Set<String> set) {

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

    public static void putAndPrint(java.util.Map<String, Integer> map) {

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

        addAndPrint(new java.util.HashSet<String>());

        addAndPrint(new java.util.TreeSet<String>());

        putAndPrint(new java.util.HashMap<>());

        putAndPrint(new java.util.TreeMap<>());

    }
}