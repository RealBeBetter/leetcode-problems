package structure.lru;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author Real
 * @since 2024/1/6 18:26
 */
class LRUCache<K, V> {

    private final Integer capacity;
    private final LinkedList<K> cacheKeys;
    private final LinkedHashMap<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
        cacheKeys = new LinkedList<>();
    }

    /**
     * 使用 LinkedList 作为辅助工具，将最近访问到的数据 Key
     * 放到队首，最久没用的放到队尾
     *
     * @param key 键
     * @return int
     */
    public V get(K key) {
        V value = cache.get(key);
        if (value == null) {
            return null;
        }

        cache.remove(key);
        cache.put(key, value);
        updateKeys(key);
        return value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            // 更新
            cache.put(key, value);
            updateKeys(key);
            return;
        }

        // 不包含 Key 的情况下插入
        if (cache.size() == capacity) {
            cache.remove(cacheKeys.getLast());
            cache.put(key, value);
            cacheKeys.removeLast();
            cacheKeys.add(0, key);
        } else {
            cacheKeys.addFirst(key);
            cache.put(key, value);
        }
    }

    private void updateKeys(K key) {
        cacheKeys.remove(key);
        cacheKeys.add(0, key);
    }
}
