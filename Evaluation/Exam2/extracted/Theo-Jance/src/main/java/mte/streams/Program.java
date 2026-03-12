package mte.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    //Identify High Achiever
    public void partA(List<Student> students) {
        //TODO: Add Part A Solution here
        students.stream().filter(s -> s.getGrade() > 85)
        .forEach(s -> System.out.println(s.getName() + " - " + s.getGrade()));
        


        
    }

    //Find Adult Student
    public void partB(List<Student> students) {
        //TODO: ADD Part B Solution here
        students.stream().filter(s -> s.getAge() >= 18)
        .forEach(s -> System.out.println(s.getName() + " - " + s.getAge()));




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
