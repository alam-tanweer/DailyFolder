package unit06;

import java.util.Comparator;

public class AlienComparator implements Comparator<AlienAlphabet> {

    @Override
    public int compare(AlienAlphabet o1, AlienAlphabet o2) {
        String symbol1 = o1.getSymbol();
        String symbol2 = o2.getSymbol();
        return symbol1.toLowerCase().compareTo(symbol2.toLowerCase());
    }
    
}
