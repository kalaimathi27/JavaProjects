import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache {
    int capacity;
    Map<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
        }
        else if(cache.size() == capacity){
            int first = 0;
            for(Map.Entry<Integer, Integer> it :
                    cache.entrySet()){
                first = it.getKey();
                break;
            }
            cache.remove(first);
        }
        cache.put(key, value);
    }

    public static void main(String[] args){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        int x = lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);
    }
}
