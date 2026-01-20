package unit02.assignment2.chickens;

public class Egg {
    private final Color color;
    private final Size size;
    private boolean cracked;

    public Egg(Color color, Size size) {
        this.color = color;
        this.size = size;
        this.cracked = false;
    }

    public void crack() {
        this.cracked = true;
    }

    public boolean isCracked() {
        return this.cracked;
    }

    public Color getColor() {
        return this.color;
    }

    public Size getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return (cracked ? "A cracked " : "An uncracked ") + this.color + " " 
            + this.size + " (" + this.size.getOunces() + "oz.) egg";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Egg) {
            Egg other = (Egg)obj;
            return this.size == other.size && this.color == other.color 
                && this.cracked == other.cracked;
        } else {
            return false;
        }
    }
}
