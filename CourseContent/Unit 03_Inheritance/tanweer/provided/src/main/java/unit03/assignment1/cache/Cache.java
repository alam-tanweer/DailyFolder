package unit03.assignment1.cache;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public abstract class Cache {
    protected final int CACHE_LENGTH;
    private String[] cache;
    private String fileName;
    protected int cacheHit;
    protected int cacheMiss;

    public Cache(String fileName, int length){
        cacheHit = 0;
        cacheMiss = 0;
        this.fileName = fileName;
        this.CACHE_LENGTH = length;
        cache = new String[length];
        try(
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String line;
            int lineCount = 0;
            while((line = bufferedReader.readLine()) != null){
                if(lineCount >= CACHE_LENGTH){
                    break;
                }
                cache[lineCount] = line;
                lineCount++;
            }
        }
        catch(IOException e){
            System.out.println("IO exception!!");
        }

    }
    public String[] getCache(){
        return cache;
    }
    
    public String getFileName(){
        return fileName;
    }
    public String getCacheElement(int i){
        return cache[i];
    }
    public void setCacheElement(int i, String target){
        cache[i] = target;
    }
    //used by RandomCache
    public boolean search(String target){
        // search cache first
        for(int i=0; i<cache.length; i++){
            if(cache[i].equals(target)){
                cacheHit++;
                return true; //cache hit
            }
        }
        return fileSearch(target);
    }
    public int getCacheHit(){
        return cacheHit;
    }
    public int getCacheMiss(){
        return cacheMiss;
    }
    //used by both
    public boolean fileSearch(String target){
        try(
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.equals(target)){
                    cacheMiss++;
                    updateCache(target); 
                    return true;
                }
            }
        }
        catch(IOException e){
            System.out.println("IO exception!!");  
        }
        return false;
    }

    public abstract void updateCache(String target);

    public String toString(){
        return "Cache = " + Arrays.toString(cache)
        + "\nHits = " + cacheHit
        + "\nMisses = " + cacheMiss;
    }
}

