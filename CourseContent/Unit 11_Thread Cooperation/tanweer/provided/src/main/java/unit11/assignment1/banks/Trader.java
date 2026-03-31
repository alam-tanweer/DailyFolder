package unit11.assignment1.banks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 * Producer in this assignment, buys and sells stocks.
 */
public class Trader implements Runnable {
    private static final Random RNG = new Random(1);

    private final String name;
    private final LinkedList<String> queue;
    private final String[] stocks;
    private final Map<String, Integer> stockAmounts;

    /**
     * Constructor
     * @param name name of the trader
     * @param queue the producer/consumer queue
     * @param stocks the stocks the trader is interested in
     */
    public Trader(String name, LinkedList<String> queue, String[] stocks) {
        this.name = name;
        this.queue = queue;
        this.stocks = stocks;
        this.stockAmounts = new HashMap<>();
        for(String stock: stocks){
            stockAmounts.put(stock, 0);
        }
    }

    /**
     * Helper function to choose a stock to sell
     * @return a String representing the stock to sell
     */
    private String chooseStockToSell(){
        ArrayList<String> ownedStocks = new ArrayList<>();
        for(String stock: stocks){
            if(stockAmounts.get(stock) != 0){
                ownedStocks.add(stock);
            }
        }
        if(ownedStocks.size() > 0){
            int toSell = RNG.nextInt(ownedStocks.size());
            String stockNameToSell = ownedStocks.get(toSell);
            int purchased = stockAmounts.get(stockNameToSell) - 1;
            stockAmounts.put(stockNameToSell, purchased);
            return stockNameToSell;
        }
        return "";
    }

    /**
     * Trader buys and sells stocks by putting messages in the 
     * queue which is later translated into actual purchases by
     * the banks.
     */
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // squash
            }
            
            int numberOfTrades = RNG.nextInt(4) + 1;
            
            for(int i = 0; i < numberOfTrades; i++) {
                String tradeString = name + ",";
                int buyOrSell = RNG.nextInt(2);
                if(buyOrSell == 0){
                    int stockNum = RNG.nextInt(stocks.length);
                    String stockName = stocks[stockNum];

                    tradeString += stockName + ",";
                    tradeString += "purchase";

                    int purchased = stockAmounts.get(stockName) + 1;
                    stockAmounts.put(stockName, purchased);
                }else{
                    String stockToSell = chooseStockToSell();
                    if(!stockToSell.equals("")){
                        tradeString += stockToSell + ",sell";
                    }else{
                        tradeString = "";
                    }
                }
                if(!tradeString.equals("")){
                    synchronized(queue){
                        queue.add(tradeString);
                    }
                }

                synchronized(queue){
                    queue.notifyAll();
                }
            }
        }
    }
}
