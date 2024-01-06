package structure.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Real
 * @since 2024/1/6 19:08
 */
public class DoubleLinkedLruCache<K, V> {

    private final Map<K, Node<K, V>> keyToNodeMap;
    private final DoubleLinkedList<K, V> linkedList;

    private int size;
    private final int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public DoubleLinkedLruCache(int initialCapacity) {
        if (initialCapacity <= 0) {
            this.capacity = DEFAULT_CAPACITY;
        } else {
            this.capacity = initialCapacity;
        }

        this.keyToNodeMap = new HashMap<>();
        this.linkedList = new DoubleLinkedList<>();
        this.size = 0;
    }

    /**
     * 获取一个 Key，并将元素移动到链表尾部
     *
     * @param key key 值
     * @return val值
     */
    public V get(K key) {
        if (!keyToNodeMap.containsKey(key)) {
            return null;
        }

        // 将节点移动到末尾
        moveNodeToTail(key);
        return keyToNodeMap.get(key).val;
    }

    private void moveNodeToTail(K key) {
        Node<K, V> node = keyToNodeMap.get(key);
        linkedList.remove(node);
        linkedList.addLast(node);
    }


    public void put(K key, V val) {
        // 如果存在，直接将旧节点放到末尾即可
        if (keyToNodeMap.containsKey(key)) {
            removeNode(key);
            addNewNode(key, val);
        }

        // 不存在，需要判断容量，是否需要淘汰节点
        if (this.capacity <= this.size) {
            removeFirst();
        }

        addNewNode(key, val);
    }


    private void removeFirst() {
        Node<K, V> needDelNode = linkedList.head.next;
        removeNode(needDelNode.key);
    }

    private void removeNode(K key) {
        Node<K, V> node = keyToNodeMap.get(key);
        linkedList.remove(node);
        keyToNodeMap.remove(key);
        size--;
    }

    private void addNewNode(K key, V val) {
        Node<K, V> node = new Node<>(key, val);
        linkedList.addLast(node);
        keyToNodeMap.put(key, node);
        size++;
    }

    private static class DoubleLinkedList<K, V> {
        Node<K, V> head, tail;

        DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 添加节点到链表末尾
         */
        void addLast(Node<K, V> node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        /**
         * 删除节点
         */
        void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

    private static class Node<K, V> {
        K key;
        V val;
        /**
         * 前后节点
         */
        Node<K, V> prev, next;

        Node() {
        }

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

}
