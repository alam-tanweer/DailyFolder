package unit08.assignment1.haunted;

public class Area {
    private final String name;
    private final AreaType type;
    private String evilPresence;

    public Area(String name,AreaType type) {
        this.name = name;
        this.type = type;
        this.evilPresence = null;
    }

    public String getName() {
        return name;
    }

    public AreaType getType() {
        return type;
    }

    public boolean isHaunted() {
        return evilPresence != null;
    }

    public void haunt(String evilPresence) {
        this.evilPresence = evilPresence;
    }

    @Override
    public String toString() {
        String s = name + " [" + type;

        if (evilPresence != null)
            s += "/" + evilPresence;

        return s + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Area) {
            Area other = (Area)o;
            return this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
