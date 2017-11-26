package cache;

import bean.Document;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {

    private static CacheManager instance;
    private Map<String, Document> cache = new HashMap();

    public synchronized static CacheManager getInstance(){
        if (instance == null){
            instance = new CacheManager();
        }
        return instance;
    }

    public Document get(String key){
        return cache.get(key);
    }

    public void add(String key, Document document){
        cache.put(key, document);
    }
}