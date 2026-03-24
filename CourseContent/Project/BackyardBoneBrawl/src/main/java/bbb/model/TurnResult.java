package bbb.model;

public class TurnResult {
    private final YardCoordinate playerDigCoordinate;
    private final DigResult playerDigResult;
    private final YardCoordinate cyberPupDigCoordinate;
    private final DigResult cyberPupDigResult;
    
    public TurnResult(YardCoordinate playerDigCoordinate,
                                    DigResult playerDigResult,
                                    YardCoordinate cyberPupDigCoordinate,
                                    DigResult cyberPupDigResult) {
        this.playerDigCoordinate = playerDigCoordinate;
        this.playerDigResult = playerDigResult;
        this.cyberPupDigCoordinate = cyberPupDigCoordinate;
        this.cyberPupDigResult = cyberPupDigResult;
    }

    public YardCoordinate getPlayerDigCoordinate() { return playerDigCoordinate; }
    public DigResult getPlayerDigResult() { return playerDigResult; }
    public YardCoordinate getCyberPupDigCoordinate() { return cyberPupDigCoordinate; }
    public DigResult getCyberPupDigResult() { return cyberPupDigResult;}

    @Override
    public String toString() {
        return "PLAYER_DIG_COORDINATE: " + playerDigCoordinate +
                "\nPLAYER_DIG_RESULT: " + playerDigResult +
                "\nCYBERPUP_DIG_COORDINATE: " + cyberPupDigCoordinate +
                "\nCYBERPUP_DIG_RESULT: " + cyberPupDigResult;
    }
}
