package unit05.practicum.hilo.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import unit05.practicum.hilo.model.HiLo;

public class TextFieldEventHandler implements EventHandler<ActionEvent> {
    private HiLo game;
    private TextField text;

    public TextFieldEventHandler(HiLo game, TextField text) {
        this.game = game;
        this.text = text;
    }

    @Override
    public void handle(ActionEvent arg0) {
        try {
            game.makeGuess(Integer.parseInt(text.getText()));
        } catch (RuntimeException e) {
            game.makeGuess(0);
        }
    }
}