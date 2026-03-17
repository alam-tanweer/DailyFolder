package unit12.assignment1.qotd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class QotD {
    private static final Random RNG = new Random();

    private final List<String> inspirational;
    private final List<String> historical;
    private final List<String> deep;

    private QotD(List<String> inspirational, 
                List<String> historical, 
                List<String> deep) {
        this.inspirational = inspirational;
        this.historical = historical;
        this.deep = deep;
    }

    public synchronized static QotD getInstance(String inspirationalFilename, 
                                                String historicalFilename, 
                                                String deepFilename) throws IOException {
        List<String> inspirational = Files.readAllLines(Paths.get(inspirationalFilename));
        List<String> historical = Files.readAllLines(Paths.get(historicalFilename));
        List<String> deep = Files.readAllLines(Paths.get(deepFilename));

        return new QotD(inspirational, historical, deep);
    }

    public String getRandomInspirationalQuote() {
        return inspirational.get(RNG.nextInt(inspirational.size()));
    }

    public String getRandomHistoricalQuote() {
        return historical.get(RNG.nextInt(historical.size()));
    }

    public String getRandomDeepQuote() {
        return deep.get(RNG.nextInt(deep.size()));
    }
    
}
