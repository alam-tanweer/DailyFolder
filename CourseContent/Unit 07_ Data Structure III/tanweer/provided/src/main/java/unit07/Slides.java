package unit07;

public class Slides {
    
    public static void joinExample () {
        String[] words = {"Java", "is", "fun"};
        String result = String.join(" ", words);
        System.out.println(result); 
        // Output: Java is fun
    }

    private String name;
    private int SSN;
    private double salary;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Slides other) {
            return name.equals(other.name) && SSN == other.SSN;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * SSN;
    }

    // Created to eleminate warning
    public double getSalary() {
        return salary;
    }
}
