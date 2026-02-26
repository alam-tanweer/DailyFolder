package unit07.starter;

public class Grocery {
    private final String name;
    private final double weight;

    public Grocery(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " (" + weight + " oz)";
    }

    public static void main(String[] args) {

        Set<Grocery> grocerySet = new HashSet<>();
        
        for (int i = 0; i < 6; i++) {
            grocerySet.add (new Grocery("Diet Coke", 16.9));
        }

        grocerySet.add (new Grocery("Diet Coke", 70.55));

        System.out.println("");
        System.out.println(grocerySet);
    }
}
