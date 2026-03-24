package bbb.model;

public enum Symbol {
    GRASS('#'),
    PART('@'),
    HOLE(' '),
    STICK('S'),
    BONE('B'),
    SQUEAKER('Q'),
    SHOE('H'),
    CHEW_ROPE('C');

    private final char asciiChar;

    Symbol(char asciiChar) {
        this.asciiChar = asciiChar;
    }

    public char getAsciiChar() {
        return asciiChar;
    }
}
