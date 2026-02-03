package unit04;


public class FruitExample {
    public interface Fruit {
        double cost (int count, double weight);
    }

    public static void main (String[] args) {
        double[] prices = {1.25, 0.49, 2.00};
        Fruit apple = new Fruit(){
            @Override
            public double cost(int count, double weight) {
                return count * prices [0];
            } 
        };

        Fruit banana = new Fruit(){
            @Override
            public double cost(int count, double weight) {
                return weight * prices [1];
            }
        };

        System.out.println(apple);
        System.out.println(banana);
    }
}
