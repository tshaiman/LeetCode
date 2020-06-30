import java.util.*;

public class LRUCache {

    private HashMap<String,String> cache = new LinkedHashMap<String, String>();

    int capacity;
    public LRUCache(int capacity){

        this.capacity = capacity;
    }

    public String get(String key) {
        if (!cache.containsKey(key))
            return null;

        String val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
        return val;
    }

    public void put(String key,String val) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
        else if (cache.size() == capacity) {
            //remove the oldest
            String oldestKey = cache.entrySet().iterator().next().getKey();
            cache.remove(oldestKey);
        }
        cache.put(key,val);

    }

    public void display() {
        for(Map.Entry<String,String> entry :  cache.entrySet()){
            System.out.print(entry.getValue());
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put("1","1");
        cache.put("2","2");
        cache.put("3","3");
        cache.put("1","1");
        cache.put("4","4");
        cache.put("5","5");

        cache.display();
    }
}
