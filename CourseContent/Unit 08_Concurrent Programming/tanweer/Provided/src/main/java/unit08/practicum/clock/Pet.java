package unit08.practicum.clock;

public abstract class Pet {
    private String species;
    
    public Pet (String species) {
        this.species = species;
    }

    public String getSpecies () {
        return species;
    }

    @Override
    public String toString() {
        return species;
    }

    public abstract String speak ();

    public static void main(String[] args) {
        Pet[] pets = new Pet[3];

        pets[0] = new Pet ("Cat") {
            public String speak () {
                return "Meow";
            }
        };

        pets[1] = new Pet ("Goldfish") {
            public String speak () {
                return "Bubble Bubble";
            }
        };

        pets[2] = new Pet ("Hamster") {
            public String speak () {
                return "Squeak";
            }
        };

        for (Pet pet : pets) {
            System.out.println (pet + " says, \"" + pet.speak () + "\".");
        }
    }
}
