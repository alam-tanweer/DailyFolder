package unit06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Student implements Comparable <Student> {
    private int id;
    private String name;
    private String email;

    public Student (int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public int hashCode(){
        int hash = (int) Math.pow(name.hashCode(),id);
        return hash; 
    }

    @Override
    public String toString() {
        return "Student {ID: " + id + ", Name: " + name + ", Email: " + email + "}";
    }

    @Override
    public int compareTo (Student other) {
        return id - other.id;
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    @Override
    public boolean equals(Object obj) { // needed to avoid duplicates
        if(obj instanceof Student) {
            Student other = (Student)obj;
            return this.name.equals(other.name) &&
                this.id == other.id;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Set<Student> hashStudents = new HashSet<>();
        Set<Student> treeStudents = new TreeSet<>();
        
        Student stu1 = new Student(9000, "Bruce", "blhvse@rit.edu");
        Student stu2 = new Student(1001, "Bobby", "rjsvcs@rit.edu");
        Student stu3 = new Student(3506, "Ahmed", "amhics@rit.edu");
        Student stu4 = new Student(9000, "Bruce", "blhvse@rit.edu");
        // For whatever reason you need at least 4 students to not have them 
        // come out in ascending key order. Got lazy typing new names.
        Student stu5 = new Student(9001, "Bruce", "blhvse@rit.edu");
        Student stu6 = new Student(1002, "Bobby", "rjsvcs@rit.edu");
        Student stu7 = new Student(3507, "Ahmed", "amhics@rit.edu");

        hashStudents.add (stu1);
        hashStudents.add (stu2);
        hashStudents.add (stu3);
        hashStudents.add (stu4);
        hashStudents.add (stu5);
        hashStudents.add (stu6);
        hashStudents.add (stu7);

        for (Student stu : hashStudents) {
            System.out.println (stu);
        }

        System.out.println("==================================");

        treeStudents.add (stu1);
        treeStudents.add (stu2);
        treeStudents.add (stu3);
        treeStudents.add (stu5);
        treeStudents.add (stu6);
        treeStudents.add (stu7);

        for (Student stu : treeStudents) {
            System.out.println (stu);
        }

        System.out.println();

        Map <String, Student> hashMap = new HashMap<>();
        Map <String, Student> treeMap = new TreeMap<>();

        hashMap.put(stu1.getName(), stu1);
        hashMap.put(stu2.getName(), stu2);
        hashMap.put(stu3.getName(), stu3);
        hashMap.put(stu5.getName(), stu5);
        hashMap.put(stu6.getName(), stu6);
        hashMap.put(stu7.getName(), stu7);

        for (String name : hashMap.keySet()) {
            System.out.println (hashMap.get (name));
        }

        System.out.println();

        treeMap.put(stu1.getName(), stu1);
        treeMap.put(stu2.getName(), stu2);
        treeMap.put(stu3.getName(), stu3);
        treeMap.put(stu5.getName(), stu5);
        treeMap.put(stu6.getName(), stu6);
        treeMap.put(stu7.getName(), stu7);

        for (String name : treeMap.keySet()) {
            System.out.println (treeMap.get (name));
        }

    }
}