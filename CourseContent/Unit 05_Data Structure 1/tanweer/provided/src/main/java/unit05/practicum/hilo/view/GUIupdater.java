package unit05.practicum.hilo.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import unit05.practicum.hilo.model.HiLo;
import unit05.practicum.hilo.model.HiLoObserver;

public class GUIupdater implements HiLoObserver {
    private HiLoGUI gui;

    public GUIupdater(HiLoGUI gui) {
        this.gui = gui;
    }

    @Override
    public void update(HiLo game) {
        String strHint = game.getHint();
        Label hint = gui.getHint();
        Label availableGuesses = gui.getAvailableGuesses();
        TextField text = gui.getText();

        int intAvailableGuesses = game.getAvailableGuesses();
        boolean gameOver = game.isGameOver();
        hint.setText(strHint);
        text.setText("");
        if (gameOver) {
            text.setDisable(true);
        }
        availableGuesses.setText(intAvailableGuesses + " guesses left");

    }
}