package unit03.assignment1.cache;
public class RoundRobinCache extends Cache{
    private int index; 
    public RoundRobinCache(String fileName, int length){
        super(fileName, length);
        index = 0;
    }
    @Override
    public void updateCache(String target){
        setCacheElement(index, target);
        index = (index + 1)%CACHE_LENGTH;
    }
    
    public static void main(String[] args){
        int cacheLength = 3;
        Cache rrCache = new RoundRobinCache("data/letters.txt", cacheLength); //cache = [A, B, C], count = [0,0,0]
        String[] queries = {"A", "E", "A", "H", "G", "E"}; 
        System.out.println("Testing round robin cache ...");
        for(int i=0; i<queries.length; i++){
            String target = queries[i];
            boolean result = rrCache.search(target);//always true with the queries 
            System.out.println("\nAfter search target " + target + ":" + result);
            System.out.println(rrCache);
        }    
    }
}

