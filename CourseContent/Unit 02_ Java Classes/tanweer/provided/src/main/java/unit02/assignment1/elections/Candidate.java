package unit02.assignment1.elections;

public class Candidate {
    private final Race race;
    private final Party party;
    private final String name;

    public Candidate (String name, Party party, Race race) {
        this.name = name;
        this.party = party;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public Party getParty() {
        return party;
    }

    @Override
    public String toString () {
        return String.format ("%s: Running for %s as a %s.", name, race, party);
    }


    @Override
    public boolean equals (Object obj) {
        if (obj instanceof Candidate) {
            Candidate other = (Candidate) obj;
            if (other.name.equals (name) && other.race == this.race) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String hello = "Hello";
        String world = "World";
        String out = String.format ("%s %s!", hello, world);
        System.out.println(out);
    }
}
