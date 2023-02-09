package hot100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wei.song
 * @since 2023/2/9 22:46
 */
public class HookLruCache extends LinkedHashMap<Integer, Integer> {

    private Integer capacity;

    public HookLruCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = super.get(key);
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
