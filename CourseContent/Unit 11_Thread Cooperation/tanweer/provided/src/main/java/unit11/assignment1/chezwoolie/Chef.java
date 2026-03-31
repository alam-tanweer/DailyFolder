package unit11.assignment1.chezwoolie;

import java.util.Random;

public class Chef implements Runnable {
    private static final Random RNG = new Random(1);

    private static final Food[] FOODS = {
        new Food("Hamburger", 4),
        new Food("Turkey Leg", 3),
        new Food("Dumplings", 1),
        new Food("Spicy Tuna Roll", 1),
        new Food("French Fries", 2),
        new Food("Cajun Fries", 2),
        new Food("Banana Split", 5),
        new Food("Strawberry Shortcake", 2),
        new Food("Rice Pudding", 1),
        new Food("Dragon Roll", 1),
        new Food("Shrimp Tempura", 3),
        new Food("Pepperoni Pizza", 2),
        new Food("Taco Salad", 3),
        new Food("Coffee", 1)
    };

    private final String name;
    private final ChezWoolie chezWoolie;

    public Chef(String name, ChezWoolie chezWoolie) {
        this.name = name;
        this.chezWoolie = chezWoolie;
    }

    @Override
    public void run() {
        synchronized(chezWoolie) {
            while(chezWoolie.getDinerCount() == 0) {
                System.out.println(this + " is early! Waiting for customers.");
                try {
                    chezWoolie.wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }
        }

        while(chezWoolie.getDinerCount() > 0) {
            Food food = FOODS[RNG.nextInt(FOODS.length)];
            System.out.println(this + " begins to prepare " + food);
            try {
                Thread.sleep(food.getServings() * ChezWoolie.WECOND);
            } catch (InterruptedException e) {
                // squash
            }
            System.out.println(this + " finishes " + food + 
                " and places it on the conveyor belt.");
            chezWoolie.serveFood(food);
        }

    }

    @Override
    public String toString() {
        return "Chef " + name;
    }
}
