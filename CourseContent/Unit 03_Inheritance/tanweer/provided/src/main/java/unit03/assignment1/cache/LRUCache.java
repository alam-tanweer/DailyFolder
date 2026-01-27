package unit03.assignment1.cache;
import java.util.Arrays;

public class LRUCache extends Cache {
    private int[] frequency;

    public LRUCache(String fileName, int length){
        super(fileName, length);
        frequency = new int[CACHE_LENGTH];
    }

    @Override
    public boolean search(String target){
        for(int i=0; i<CACHE_LENGTH; i++){
            if(getCacheElement(i).equals(target)){
                frequency[i]+=1;
                cacheHit++;
                return true; //cache hit
            }
        }
        return fileSearch(target);
    }

    public void updateCache(String target){ 
        int minFrequency = frequency[0];
        int minIndex = 0;
        for(int i=1; i<CACHE_LENGTH; i++){
            if(minFrequency > frequency[i]){
                minFrequency = frequency[i];
                minIndex = i;
            }
        }
        
        setCacheElement(minIndex, target);
        frequency[minIndex] = 1;
    }
    @Override
    public String toString(){
        String cacheString = "Cache = " + Arrays.toString(getCache());
        cacheString += "\nCount = " + Arrays.toString(frequency);
        cacheString += "\n# Hits = " + getCacheHit();
        cacheString += "\n# Misses = " + getCacheMiss();
        return cacheString;
    }

    public static void main(String[] args){
        int cacheLength = 3;
        Cache lruCache = new LRUCache("letters.txt", cacheLength); //cache = [A, B, C], count = [0,0,0]
        String[] queries = {"A", "E", "A", "H", "G", "E"}; 
        System.out.println("Testing LRU cache ...");
        for(int i=0; i<queries.length; i++){
            String target = queries[i];
            boolean result = lruCache.search(target);//always true with the queries 
            System.out.println("\nAfter search target " + target + ":" + result);
            System.out.println(lruCache);
        }    
    }   
}
