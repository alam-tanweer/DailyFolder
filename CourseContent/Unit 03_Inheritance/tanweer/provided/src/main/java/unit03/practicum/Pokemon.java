package unit03.practicum;

public class Pokemon {
    private String name;
    private PokemonType type;
    private int level;
    
    public Pokemon(String name, PokemonType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon(String name, PokemonType type) {
        this(name, type, 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        if(level < 100) {
            level++;
        }
    }

    @Override
    public String toString() {
        return "Pokemon{name=" + this.name
            + ", type=" + this.type
            + ", level=" + this.level
            + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pokemon) {
            Pokemon other = (Pokemon)obj;
            return other.type == this.type &&
                other.level == this.level;
        } else {
            return false;
        }
    }
}
