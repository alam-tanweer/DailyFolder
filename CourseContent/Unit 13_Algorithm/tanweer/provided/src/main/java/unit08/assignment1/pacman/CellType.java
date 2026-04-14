package unit08.assignment1.pacman;

public enum CellType {
    PELLET("PE"),
    POWER_PELLET("PP"),
    GHOST("GH"),
    PAC_MAN("PM");
    
    private final String shortHand;

    private CellType(String shortHand) {
        this.shortHand = shortHand;
    }

    @Override
    public String toString() {
        return shortHand;
    }
}
