package unit03.activities;

public interface Animal {
    public static final String KINGDOM = "Animalia";

    public static String getKingdom() {
        return KINGDOM;
    }

    public abstract void speak();    
}
