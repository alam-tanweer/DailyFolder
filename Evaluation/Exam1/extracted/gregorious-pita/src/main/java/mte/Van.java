package mte;

public class Van extends Vehicle {
    
    public Van(String name, double mpg, int passengers) {
        super(name, (mpg - (passengers * 0.5)));
    }

    public static void main(String[] args) {
        Van van1 = new Van("Van", 12, 3);
        Van van2 = new Van ("Van", 12, 3);
        System.out.println(van1.equals(van2));
    }
}
