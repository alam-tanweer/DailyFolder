package Day02;

import java.util.*;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}

    @Override
    public String toString() {
        return lastName + "," + firstName;
    }

    @Override
    public int compareTo(Student o) {
        return this.firstName.compareTo(o.firstName);
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return a.getLastName().compareTo(b.getLastName());
        }
    }

    public static int compareByFirstName(Student a, Student b) {
        return a.firstName.compareTo(b.firstName);
    }

    public static void main(String[] args) {
        List<Student> students = new LinkedList<>();
        students.add(new Student("Bart","Simpson"));
        students.add(new Student("Milhouse","VanHouten"));
        students.add(new Student("Todd","Flanders"));
        students.add(new Student("Nelson","Muntz"));
        students.add(new Student("Ralph","Wiggum"));

        // Use student compare method since they are comparable
        Collections.sort(students);
        System.out.println(students);

        // Use innner comparator class
        students.sort(new Student.StudentComparator());
        System.out.println(students);

        // Use anonymous class
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.getLastName().compareTo(b.getLastName());
            }
        });
        System.out.println(students);

        // Use lambda
        Comparator<Student> studentCompLambda = (b, a) -> {
            return a.getFirstName().compareTo(b.getFirstName());
        };
        students.sort(studentCompLambda);
        System.out.println(students);

        // Use short lambda
        students.sort((a, b) -> a.getLastName().compareTo(b.getLastName()));
        System.out.println(students);

        // Use method reference
        students.sort(Student::compareTo);
        System.out.println(students);

        // Use method reference
        students.sort(Student::compareByFirstName);
        System.out.println(students);

        // Use filter
        students.stream().filter(s -> s.toString().toLowerCase().contains("s")).
            forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }
}
