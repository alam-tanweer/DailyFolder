package unit02.assignment2.chickens;

import java.util.Random;

public class Chicken {
    private static final Random RNG = new Random(1);
    private static final String[] NAMES = {
        "Abrahen Lincoln",
        "Albert Eggstein",
        "Angelina Jopeep",
        "Bradley Coop-er",
        "Chick Jagger",
        "Chicken Little",
        "Cluck Norris",
        "Cluck Vader",
        "Eggatha Christie",
        "Foghorn Leghorn",
        "Hen Solo",
        "Henifer Aniston",
        "Henny Penny",
        "Hillary Fluff",
        "M-egg-atron",
        "Princess Lay-a",
        "Optimeggs Prime",
        "Sal Monella",
        "Tootsie",
        "Yolko Ono"
    };

    private final String name;
    private final Color color;
    private final Size size;

    public Chicken(String name) {
        this(name, Color.BROWN, Size.LARGE);
    }

    public Chicken(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public static Chicken randomChicken() {
        String name = NAMES[RNG.nextInt(NAMES.length)];
        Size[] sizes = Size.values();
        Size size = sizes[RNG.nextInt(sizes.length)];
        Color[] colors = Color.values();
        Color color = colors[RNG.nextInt(colors.length)];

        return new Chicken(name, color, size);
    }

    public Egg layEgg() {
        return new Egg(color, size);
    }

    public String getName() {
        return this.name;
    }

    public Size getSize() {
        return this.size;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return name + ", a chicken that lays " + this.size + " " 
            + this.color + " eggs";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Chicken) {
            Chicken other = (Chicken)obj;
            return this.size == other.size;
        } else {
            return false;
        }
    }
}
