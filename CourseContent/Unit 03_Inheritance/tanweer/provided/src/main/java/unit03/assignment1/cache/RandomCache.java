package unit03.assignment1.cache;
import java.util.Random;

public class RandomCache extends Cache{
    private static final Random RNG = new Random(0);
    
    public RandomCache(String fileName, int length){
        super(fileName, length);
    }
    public void updateCache(String target){
        int i = RNG.nextInt(CACHE_LENGTH);
        setCacheElement(i, target);
    } 
    public static void main(String[] args){
        int cacheLength = 3;
        Cache randomCache = new RandomCache("letters.txt", cacheLength); //cache = [A, B, C], count = [0,0,0]
        String[] queries = {"A", "E", "A", "H", "G", "E"};
        System.out.println("Testing random cache ..."); 
        for(int i=0; i<queries.length; i++){
            String target = queries[i];
            boolean result = randomCache.search(target);//always true with the queries 
            System.out.println("\nAfter search target " + target + ":" + result);
            System.out.println(randomCache);
        }    
    }
}

