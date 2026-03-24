package bbb.model;

public interface BackyardBoneBrawlGame {
    TurnResult takeTurn(YardCoordinate coord);
    String getPlayerYard();
    String getCyberPupYard();
    GameState getGameState();
}
