package Day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student_2205 implements Comparable <Student_2205>{
    private final String fName;
    private final String lName;
    private double gpa;

    public Student_2205(String fName, String lName, double gpa) {
        this.fName = fName;
        this.lName = lName;
        this.gpa = gpa;
    }

    public String getfName () {
        return fName;
    }

    public String getlName () {
        return lName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString () {
        return lName + "," + fName;
    }

    @Override
    public int compareTo (Student_2205 o) {
        return fName.compareTo (o.fName);
    }

    public static void main (String[] args) {
        List <Student_2205> students = new ArrayList<> ();
        students.add (new Student_2205 ("Bruce", "Herring", 3.6));
        students.add (new Student_2205 ("Bobby", "St. Jacques", 2.9));
        students.add (new Student_2205 ("Ahmed", "Hamza", 3.4));
        students.add (new Student_2205 ("Gahyun", "Park", 4.0));

        System.out.println (students);
        students.sort (new Comparator <Student_2205>(){
            @Override
            public int compare(Student_2205 o1, Student_2205 o2) {
                return o1.getlName ().compareTo (o2.getlName ());
            }
        });

        System.out.println (students);

        students.sort ( (Student_2205 a, Student_2205 b) -> {
            return b.lName.compareTo (a.lName);
        });
        
        System.out.println (students);

        students.sort ( (a, b) -> b.fName.compareTo (a.fName) );

        System.out.println (students);

        students.sort (Student_2205::compareTo);

        System.out.println (students);

        students.stream().forEach (e -> System.out.println (e.fName + " " + e.lName));

        students.stream().filter(e -> e.gpa >= 3.6).forEach(System.out::println);
    }
}
  
