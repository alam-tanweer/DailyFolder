package unit02.examples;

public enum Species {
    CAT,
    DOG,
    BIRD,
    FISH,
    LIZARD,
    HAMSTER;

    public static void main(String[] args) {
        Species species = Species.DOG;
        System.out.println(species);
    }
}
