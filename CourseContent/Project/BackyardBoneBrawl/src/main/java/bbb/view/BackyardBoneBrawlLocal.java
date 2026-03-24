package bbb.view;

import bbb.model.BackyardBoneBrawlGame;
import bbb.model.BackyardBoneBrawlGameImpl;

public class BackyardBoneBrawlLocal {
    public static void main(String[] args) {
        BackyardBoneBrawlGame game = new BackyardBoneBrawlGameImpl();
        TopDog topDog = new TopDog(game);
        topDog.play();
    }
}
