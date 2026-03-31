package unit11.assignment1.banks;

import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for the main method running the simulation of Wall Street.
 */
public class Main {
    public static void main(String[] args){
        LinkedList<String> queue = new LinkedList<>();
        Stock gameStop = new Stock("GME");
        Stock doge = new Stock("DOGE-USD");
        Stock bestBuy = new Stock("BBY");
        Stock microsoft = new Stock("MSFT");
        Stock popInc = new Stock("BPOP");

        Map<String, Stock> stockMap = new HashMap<>();
        stockMap.put("GME", gameStop);
        stockMap.put("DOGE-USD", doge);
        stockMap.put("BBY", bestBuy);
        stockMap.put("MSFT", microsoft);
        stockMap.put("BPOP", popInc);


        WallStreet wallStreet = new WallStreet(stockMap);

        ArrayList<Trader> traders = new ArrayList<>();
        String[] treyStocks = new String[]{"GME", "DOGE-USD", "MSFT"};
        traders.add(new Trader("Trey", queue, treyStocks));

        String[] bobbyStocks = new String[]{"MSFT", "BPOP", "GME", "BBY"};
        traders.add(new Trader("Bobby", queue, bobbyStocks));

        String[] bruceStocks = new String[]{"DOGE-USD", "BBY", "BPOP"};
        traders.add(new Trader("Bruce", queue, bruceStocks));

        for(int i = 0; i < 2; i++){
            Thread t = new Thread(new Bank(i, queue, wallStreet));
            t.start();
        }

        for(Trader trader: traders){
            Thread t = new Thread(trader);
            t.start();
        }
    }
}
