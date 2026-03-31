package unit11.assignment1.chezwoolie;

public class Diner implements Runnable {
    private final String name;
    private int hunger;
    private final ChezWoolie chezWoolie;

    public Diner(String name, int hunger, ChezWoolie chezWoolie) {
        this.name = name;
        this.hunger = hunger;
        this.chezWoolie = chezWoolie;
    }

    public void eat(Food food) {
        System.out.println(this + " begins to eat " + food);
        try {
            Thread.sleep(food.getServings() * ChezWoolie.WECOND);
        } catch (InterruptedException e) {
            // squash
        }
        hunger -= food.getServings();
        System.out.println(this + " finishes eating " + food 
            + " and is " + (hunger > 0 ? "still hungry!" : "full!"));
    }

    @Override
    public void run() {
        System.out.println(this + " enters the restaurant!");
        chezWoolie.enter();
        while(hunger > 0) {
            System.out.println(this + " wants " + hunger 
                + " servings of food!");
            Food food = chezWoolie.retrieveFood();
            eat(food);
        }
        System.out.println(this + " exits the restaurant!");
        chezWoolie.exit();
    }

    @Override
    public String toString() {
        return "Diner " + name;
    }
}
