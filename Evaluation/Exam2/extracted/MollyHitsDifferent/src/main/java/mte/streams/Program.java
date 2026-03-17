package mte.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    //Identify High Achiever
    public void partA(List<Student> students) {
        // Student[] x = students.();
        // students.stream(students).filter(x -> x.getGrade() >= 85).forEach(println::getName + " - " + getGrade));
    //    Arrays.asList(students).stream().filter(Student x -> x.getGrade() >= 85).forEach(System.out.println(x.getGrade() + " - " + x.getName()));
       students.stream().filter(x -> x.getGrade() >= 85).forEach(x -> System.out.println(x.getGrade() + " - " + x.getName()));
        
    }

    //Find Adult Student
    public void partB(List<Student> students) {

        // Arrays.asList(students).stream().forEach(System.out.println(x.getName() + " - " + x.getAge()));



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
