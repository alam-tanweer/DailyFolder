package mte.streams;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String major;

    public Student(String name, int age, double grade, String major) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
    public String getMajor() { return major; }
}
