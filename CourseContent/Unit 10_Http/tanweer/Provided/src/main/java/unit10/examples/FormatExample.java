package unit10.examples;

public class FormatExample {
    public static void main(String[] args) {
        String department = "GCIS";
        int courseCode = 124;
        int section = 1;

        String courseInfo = "%s %d-%02d".formatted(department, courseCode, section);
        System.out.println(courseInfo);
    }

}
