package unit03.assignment1.toys;

import java.util.Random;

public class Doll extends Toy {
    private static final Random RNG = new Random();

    private static final String[] SAYINGS = {
        "My name is Talky Tina, and I love you very much.",
        "My name is Talky Tina, and you better be nice to me.",
        "My name is Talky Tina, and I don't think I like you.",
        "My name is Talky Tina, and I think I could even hate you.",
        "My name is Talky Tina, and you'll be sorry.",
        "My name is Talky Tina, and I'm going to kill you.",
        "My name is Talky Tina, and I don't forgive you!"
    };


    private final String hairColor;
    private final String eyeColor;
    private final String[] sayings;
    private int played;

    public Doll(double msrp, String hairColor, String eyeColor) {
        this("Doll", msrp, hairColor, eyeColor, SAYINGS);
    }

    protected Doll(String name, double msrp, String hairColor, String eyeColor,
        String[] sayings) {
        super(name, msrp);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.sayings = sayings;
        this.played = 0;
    }

    @Override
    public void play() {
        if(!isBroken()) {
            String saying = sayings[RNG.nextInt(sayings.length)];

            System.out.println("You pull the string and the doll says \""
                + saying + "\"");
                played++;
        } else {
            System.out.println("You pull the string, but nothing happens.");
        } 
    }

    public boolean isBroken() {
        return played >= 10;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }
}

