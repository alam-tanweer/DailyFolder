package unit04.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class that represents a student with a first and last na
 */
public class Student {
    /**
     * The student's first name.
     */
    private final String firstName;

    /**
     * The student's last name.
     */
    private final String lastName;

    /**
     * Creates a new student.
     * 
     * @param firstName The new student's first name.
     * @param lastName  The new student's last name.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" + this.lastName + ", " + this.firstName + "}";
    }

    public static void main(String[] args) {

        // create array with initializer
        Student[] students = {
                new Student("Alice", "Johnson"),
                new Student("Brian", "Smith"),
                new Student("Carla", "Lopez"),
                new Student("David", "Nguyen"),
                new Student("Emma", "Brown")
        };

        // print array
        System.out.println(Arrays.toString(students));

        Arrays.stream(students)
                .forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName()));

        // for(Student student : students){
        // System.out.println(student.getFirstName() + " " + student.getLastName())
        // }

        // Another Example
        Arrays.stream(students).map(Student::getFirstName)
                .forEach(System.out::println);

        // 4.12
        System.out.println("=========");
        // Arrays.stream(students)
        // .filter(s -> s.getLastName().toLowerCase().startsWith("t"))
        // .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

        Arrays.stream(students).filter(s -> s.getLastName().toLowerCase().startsWith("s"))
                .forEach(System.out::println);

        // for (Student s : students) {
        // if (s.getLastName().toLowerCase().startsWith("t")) {
        // System.out.println(s.getFirstName() + " " + s.getLastName());
        // }
        // }

        // Stream.map example
        Arrays.stream(students)
                .map(s -> s.getFirstName() + " " + s.getLastName()) // mapper
                .forEach(System.out::println);

        // Collection example
        List<String> names = Arrays.stream(students)
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.toList());

        System.out.println(names);

        //String.match example
        String s1 = "12345";
        String s2 = "123a5";

        System.out.println(s1.matches("\\d+")); // true
        System.out.println(s2.matches("\\d+")); // false

    }
}
