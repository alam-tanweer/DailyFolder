package unit03.assignment1.toys;

public class ActionFigure extends Doll {
    private static final String[] ACTION_PHRASES = {
        "Yippe Ki Yay, Peanutbutter!",
        "Welcome to the party, pal!",
        "All things being equal, I'd rather be in Philadelphia.",
        "Come out to the coast. Have a few laughs."
    };

    private final boolean kungFuGrip;

    public ActionFigure(String name, double msrp, String hairColor, 
        String eyeColor, boolean kungFuGrip) {
        super("Action Figure", msrp, hairColor, eyeColor, ACTION_PHRASES);
        this.kungFuGrip = kungFuGrip;
    }

    @Override
    public void play() {
        if(!isBroken()) {
            if(kungFuGrip) {
                System.out.println("The action figure brandishes a sword in "
                    + "its Kung-Fu Grip(tm).");
            } else {
                System.out.println("The action figure poses for action!");
            }
        } else {
            System.out.println("The action figure is broken.");
        }
    }
}
