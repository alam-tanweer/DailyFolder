package unit11.assignment1.banks;

import java.util.Map;

/**
 * The representation of WallStreet. Does the stock trading.
 */
public class WallStreet {
    // The map of all the stocks, mapped to their stock name
    private Map<String, Stock> stockMap;

    /**
     * Constructor
     * @param stockMap
     */
    public WallStreet(Map<String, Stock> stockMap){
        this.stockMap = stockMap;
    }

    /**
     * Purchases a stock
     * @param stockName the name of the stock
     */
    public void buyStock(String stockName){
        Stock stock = stockMap.get(stockName);
        stock.buyStock();
        System.out.println(stock);
    }

    /**
     * Sells a stock
     * @param stockName the name of the stock
     */
    public void sellStock(String stockName){
        Stock stock = stockMap.get(stockName);
        stock.sellStock();
        System.out.println(stock);
    }
}
