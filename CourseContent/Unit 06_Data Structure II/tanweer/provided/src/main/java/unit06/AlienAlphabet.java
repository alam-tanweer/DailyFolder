package unit06;

public class AlienAlphabet implements Comparable<AlienAlphabet> {
    private final int sequenceNumber;
    private final String symbol;

    public AlienAlphabet(int sequenceNumber, String symbol) {
        this.sequenceNumber = sequenceNumber;
        this.symbol = symbol;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public int compareTo(AlienAlphabet other) {
        // sort by sequence number
        return this.sequenceNumber - other.sequenceNumber;
    }    
}
