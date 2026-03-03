package mte.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    /*
     * Write a program using the Stream API to filter out students who scored more
     * than 85,
     * and then print their names and grades.
     */
    public void partA(List<Student> students) {
        students.stream()
                .filter(s -> s.getGrade() > 85)
                .forEach(s -> System.out.println(s.getName() + " - " + s.getGrade()));
    }

    /*
     * Using the map() method, convert all student names to uppercase and print
     * them.
     */
    public void partB(List<Student> students) {
        students.stream()
                .map(s -> s.getName().toUpperCase())
                .forEach(System.out::println);
    }

    /*
     * Filter students who are 18 years or older, then print their names and ages.
     */
    public void partC(List<Student> students){
        students.stream()
        .filter(s -> s.getAge() >= 18)
        .forEach(s -> System.out.println(s.getName() + " - " + s.getAge()));        
    }

    /*
     * Write a program to filter students majoring in "Computer Science", then
     * calculate
     * and print their average grade.
     */
    // public void partD(List<Student> students) {
    //     OptionalDouble avg = students.stream()
    //             .filter(s -> s.getMajor().equalsIgnoreCase("Computer Science"))
    //             .mapToDouble(Student::getGrade)
    //             .average();

    //     if (avg.isPresent()) {
    //         System.out.println("Average CS Grade: " + avg.getAsDouble());
    //     } else {
    //         System.out.println("No CS students found.");
    //     }
    // }

    public List<String> partD(List<Student> students) {
        List<String> names = students.stream()
                                     .map(Student::getName)
                                     .collect(Collectors.toList());
        return names;
    }

    public static void main(String[] args) {
        Program program = new Program();

        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 92.5, "Computer Science"),
                new Student("Bob", 18, 89.0, "Mathematics"),
                new Student("Charlie", 17, 75.0, "Physics"),
                new Student("David", 21, 95.0, "Computer Science"),
                new Student("Eve", 19, 82.0, "Engineering"),
                new Student("Frank", 22, 67.5, "History"),
                new Student("Grace", 20, 90.0, "Computer Science"),
                new Student("Heidi", 17, 88.0, "Biology"),
                new Student("Ivan", 18, 84.0, "Computer Science"),
                new Student("Judy", 19, 91.0, "Mathematics"));
        
        System.out.println("=======PART A===========");
        program.partA(students);
        System.out.println("=======PART B===========");
        program.partB(students);

    }
}
