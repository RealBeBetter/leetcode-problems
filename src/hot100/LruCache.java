package hot100;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 10^5 次 get 和 put
 *
 * @author wei.song
 * @since 2023/2/9 22:24
 */
public class LruCache {

    private final Integer capacity;
    private final LinkedList<Integer> cacheKeys;
    private final LinkedHashMap<Integer, Integer> cache;

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public LruCache(int capacity) {
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
    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) {
            return -1;
        }

        cache.remove(key);
        cache.put(key, value);
        updateKeys(key);
        return value;
    }

    public void put(int key, int value) {
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

    private void updateKeys(Integer key) {
        cacheKeys.remove((Integer) key);
        cacheKeys.add(0, key);
    }

}
