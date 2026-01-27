package unit03.activities;

import java.util.Random;

public enum GoatNames {
    NAME01 ("Chester"),
    NAME02 ("Bubba"),
    NAME03 ("Leonard"),
    NAME04 ("Huckleberry"),
    NAME05 ("Gilbert"),
    NAME06 ("Cleveland"),
    NAME07 ("Scruff"),
    NAME08 ("Edgar"),
    NAME09 ("Sammie"),
    NAME10 ("Homer"),
    NAME11 ("Finn"),
    NAME12 ("Rupert"),
    NAME13 ("Calvin"),
    NAME14 ("Floyd"),
    NAME15 ("Woody"),
    NAME16 ("Angus"),
    NAME17 ("Jasper"),
    NAME18 ("Turbo"),
    NAME19 ("Rocco"),
    NAME20 ("Colonel"),
    NAME21 ("Cornelius"),
    NAME22 ("Pogo"),
    NAME23 ("Tobias"),
    NAME24 ("Buckley"),
    NAME25 ("Pheonix"),
    NAME26 ("Beau"),
    NAME27 ("Peabody"),
    NAME28 ("Baxter"),
    NAME29 ("Milo"),
    NAME30 ("Shorty"),
    NAME31 ("Joker"),
    NAME32 ("Gideon"),
    NAME33 ("Bartholomew"),
    NAME34 ("Buford"),
    NAME35 ("Smalls"),
    NAME36 ("Jethro"),
    NAME37 ("Dodger"),
    NAME38 ("Gordie"),
    NAME39 ("Danny Boy"),
    NAME40 ("Elmer");

    private String name;
    private static Random RNG = new Random();

    private GoatNames(String name) {
        this.name =name;
    }

    public String getName() {
        return this.name;
    }

    public static String getRandomGoatName() {
        GoatNames[] names = GoatNames.values();
        int randomNameIndex = RNG.nextInt(names.length);
        return names[randomNameIndex].getName();
    }


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Goat test = new Mage(GoatNames.getRandomGoatName());
            System.out.println(test);
        }

    }

}


