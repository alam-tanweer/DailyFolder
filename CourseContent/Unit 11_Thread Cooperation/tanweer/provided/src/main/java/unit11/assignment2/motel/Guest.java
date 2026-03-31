package unit11.assignment2.motel;

public class Guest {
    private final String name;
    private boolean murdered;

    public Guest(String name) {
        this.name = name;
        this.murdered = false;
    }

    public String getName() {
        return name;
    }

    public boolean isMurdered() {
        return murdered;
    }

    public void murder() {
        this.murdered = true;
    }

    @Override
    public String toString() {
        return name + " is " + (isMurdered() ? " slain." : " alive.");
    }
}
