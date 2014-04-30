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
        
        dummyCache = consistentMap.get(1);
        dummyCache.put(1, "a");
        value = dummyCache.get(1);
        System.out.println("get(1) => " + value);
        
        dummyCache = consistentMap.get(2);
        dummyCache.put(2, "b");
        value = dummyCache.get(2);
        System.out.println("get(2) => " + value);
        
        dummyCache = consistentMap.get(3);
        dummyCache.put(3, "c");
        value = dummyCache.get(3);
        System.out.println("get(3) => " + value);
        
        dummyCache = consistentMap.get(4);
        dummyCache.put(4, "d");
        value = dummyCache.get(4);
        System.out.println("get(4) => " + value);
        
        dummyCache = consistentMap.get(5);
        dummyCache.put(5, "e");
        value = dummyCache.get(5);
        System.out.println("get(5) => " + value);
        
        dummyCache = consistentMap.get(6);
        dummyCache.put(6, "f");
        value = dummyCache.get(6);
        System.out.println("get(6) => " + value);
        
        dummyCache = consistentMap.get(7);
        dummyCache.put(7, "g");
        value = dummyCache.get(7);
        System.out.println("get(7) => " + value);
        
        dummyCache = consistentMap.get(8);
        dummyCache.put(8, "h");
        value = dummyCache.get(8);
        System.out.println("get(8) => " + value);
        
        dummyCache = consistentMap.get(9);
        dummyCache.put(9, "i");
        value = dummyCache.get(9);
        System.out.println("get(9) => " + value);
        
        dummyCache = consistentMap.get(10);
        dummyCache.put(10, "j");
        value = dummyCache.get(10);
        System.out.println("get(10) => " + value);
        
    //   String value = cache1.get(1);
    //   System.out.println("get(1) => " + value);
       
       
        
        int size = cacheList.size();
        
 /*       int k = 0;
        for(int i =0 ; i < 10; i++){
        	int bucket = Hashing.consistentHash(Hashing.md5().hashInt(i),size);
        	System.out.println(bucket);
        	
        }*/
        
        
       

       // cache1.put(1, "foo");
       // System.out.println("put(1 => foo)");


        System.out.println("Existing Cache Client..."); 
    }

}
