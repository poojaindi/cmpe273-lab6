package edu.sjsu.cmpe.cache.client;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.ArrayList;
import java.util.Collection;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Cache Client...");
        int replicas = 10;
        ArrayList<CacheServiceInterface> cacheList = new ArrayList<CacheServiceInterface>();
 
        
        CacheServiceInterface dummyCache;

        CacheServiceInterface cache1 = new DistributedCacheService(
                "http://localhost:3000");

        CacheServiceInterface cache2 = new DistributedCacheService(      		
                "http://localhost:3001");

        CacheServiceInterface cache3 = new DistributedCacheService(
                "http://localhost:3002");
        cacheList.add(cache1);
        cacheList.add(cache2);
        cacheList.add(cache3);
        ConsistentHash<CacheServiceInterface> consistentMap = new ConsistentHash(Hashing.md5(), cacheList);
//        consistentMap.add(cache1);
//        consistentMap.add(cache2);
//        consistentMap.add(cache3);
        
        String value;
        String str[] = {"x", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        int i;
        
        for(i = 1 ; i <= 10 ; i++){
        	
        	dummyCache = consistentMap.get(i);
            dummyCache.put(i, str[i]);
            value = dummyCache.get(i);
            System.out.println("get(i) => " + value);
        }
        

        System.out.println("Existing Cache Client..."); 
    }

}
