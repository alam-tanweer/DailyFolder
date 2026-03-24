package bbb.model;

import java.util.List;

public class BackyardBoneBrawlGameImpl implements BackyardBoneBrawlGame {
    private static final int GRID_SIZE = 5;

    private Yard player;
    private Yard cyberPup;

    public BackyardBoneBrawlGameImpl() {
        this.player = new Yard(GRID_SIZE);
        this.cyberPup = new Yard(GRID_SIZE);
    }

    @Override
    public TurnResult takeTurn(YardCoordinate playerDigCoordinate) {
        DigResult playerDigResult = cyberPup.digAt(playerDigCoordinate);
        if (playerDigResult != DigResult.INVALID) {
            YardCoordinate cyberPupDigCoordinate = player.getRandomCoordinate(
                List.of(Symbol.GRASS, Symbol.STICK, Symbol.BONE, 
                        Symbol.SQUEAKER, Symbol.SHOE, Symbol.CHEW_ROPE));
            DigResult cyberPupDigResult = player.digAt(cyberPupDigCoordinate);
            return new TurnResult(playerDigCoordinate, playerDigResult,
                                    cyberPupDigCoordinate, cyberPupDigResult);
        } else {
            return new TurnResult(playerDigCoordinate, playerDigResult, null, null);
        }
    }

    @Override
    public GameState getGameState() {
        if (player.allToysFound()) {
            return GameState.CYBERPUP_WON;
        } else if (cyberPup.allToysFound()) {
            return GameState.PLAYER_WON;
        } else {
            return GameState.IN_PROGRESS;
        }
    }

    @Override
    public String getPlayerYard() {
        return player.buildYardString(false);
    }

    @Override
    public String getCyberPupYard() {
        return cyberPup.buildYardString(true);
    }
}
