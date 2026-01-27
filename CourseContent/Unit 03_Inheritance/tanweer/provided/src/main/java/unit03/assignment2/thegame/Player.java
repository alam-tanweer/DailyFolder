package unit03.assignment2.thegame;

public interface Player {
    Move nextMove();

    Discard discard();

    boolean deal(int card);

    boolean handIsFull();

    boolean handIsEmpty();

    boolean confirmGameOver();
}