package unit10.assignment2.auction;

public interface AuctionProtocol {
    public static final String BID = "BID"; // client -> server
    public static final String END = "END"; // server -> client
    public static final String CURRENT = "CURRENT"; // server -> client
    public static final String ERROR = "ERROR"; // server -> client
}