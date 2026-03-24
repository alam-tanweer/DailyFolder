package bbb.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Toy {
    STICK(Symbol.STICK, 5),
    BONE(Symbol.BONE, 4),
    CHEW_ROPE(Symbol.CHEW_ROPE, 3),
    SQUEAKER(Symbol.SQUEAKER, 3),
    SHOE(Symbol.SHOE, 2);

    private final Symbol symbol;
    private final int length;

    Toy(Symbol symbol, int length) {
        this.length = length;
        this.symbol = symbol;
    }

    public int getLength() {
        return length;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public static Set<Character> getAllAsciiChars() {
        return Arrays.stream(Toy.values())
                .map(toy -> toy.getSymbol().getAsciiChar())
                .collect(Collectors.toSet());
    }
}