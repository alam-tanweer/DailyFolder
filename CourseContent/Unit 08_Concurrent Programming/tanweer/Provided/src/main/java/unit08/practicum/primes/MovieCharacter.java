package unit08.practicum.primes;

import java.util.Arrays;

public abstract class MovieCharacter {
    private String name;

    public MovieCharacter(String name) {
        this.name = name;
    }

    public String getName() {return name;}

    @Override
    public String toString() {
        return name;
    }

    public abstract String quote();
    public abstract String movie();

    public static void main(String[] args) {
        MovieCharacter[] characters = new MovieCharacter[3];

        characters[0] = new MovieCharacter("Dory") {
            @Override
            public String quote() {
                return "Just keep swimming";
            }

            @Override
            public String movie() {
                return "Finding Nemo";
            }
        };

        characters[1] = new MovieCharacter("John McClane") {
            @Override
            public String quote() {
                return "Yippe-ki-yay";
            }

            @Override
            public String movie() {
                return "Die Hard";
            }
        };

        characters[2] = new MovieCharacter("Gandalf") {
            @Override
            public String quote() {
                return "Use the force, Harry";
            }

            @Override
            public String movie() {
                return "Star Trek: First Contact";
            }
        };

        Arrays.stream(characters).forEach(c -> System.out.println(c + " said \"" + c.quote() + "\" in " + c.movie() + "."));
    }
}
