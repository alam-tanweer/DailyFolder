package bbb.view;

import java.io.IOException;

import bbb.model.BackyardBoneBrawlGame;

public class BackyardBoneBrawlNet {
    public static void main(String[] args) throws IOException {
        BackyardBoneBrawlGame game = new BackyardBoneBrawlGameProxy("localhost", 8081);
        TopDog topDog = new TopDog(game);
        topDog.play();
    }
}
