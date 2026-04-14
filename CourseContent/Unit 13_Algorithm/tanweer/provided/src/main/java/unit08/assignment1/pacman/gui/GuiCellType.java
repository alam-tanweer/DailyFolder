package unit08.assignment1.pacman.gui;

public enum GuiCellType {
    WALL("WA", null),
    PAC_MAN("PM", WALL),
    GHOST("GH", PAC_MAN),
    POWER_PELLET("PP", GHOST),
    PELLET("PE", POWER_PELLET);

    private final String shortHand;
    private final GuiCellType next;

    private GuiCellType(String shortHand, GuiCellType next) {
        this.shortHand = shortHand;
        this.next = next;
    }

    public GuiCellType next() {
        return next == null ? PELLET : next;
    }

    @Override
    public String toString() {
        return shortHand;
    }
}
