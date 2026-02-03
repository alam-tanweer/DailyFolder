package unit04;

import java.util.Arrays;

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

        Student[] students = {
                new Student("Alice", "Johnson"),
                new Student("Bob", "Smith"),
                new Student("Carlos", "Diaz"),
                new Student("Diana", "Lee"),
                new Student("Ethan", "Brown")
        };

        // System.out.println(Arrays.toString(students));

        // Arrays.stream(students).forEach(System.out::println);
        // Arrays.stream(students).forEach(e -> 
        //     System.out.println(e.getFirstName() + ", " + e.getLastName()));

        Arrays.stream(students).filter(e -> e.getLastName().toLowerCase().startsWith("s")).forEach(e -> 

                System.out.println(e.getFirstName() + ", " + e.getLastName()));
    }
}