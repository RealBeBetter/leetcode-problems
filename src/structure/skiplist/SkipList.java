package structure.skiplist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wei.song
 * @since 2023/8/26 16:31
 */
public class SkipList {

    /**
     * 最原始的链表头
     */
    private Node head;
    /**
     * 最终的跳表结构，包含原始链表和索引链表
     */
    private final List<Node> finalList;
    /**
     * 跳表层数
     */
    private int level;

    static class Node {

        /**
         * 当前节点值
         */
        private int value;
        /**
         * 当前节点所属链表的下一个节点
         */
        private Node next;
        /**
         * 当前节点所属链表的前一个节点
         */
        private Node prev;
        /**
         * 当前节点下一条索引链表的起始节点
         */
        private Node nextIndexNode;

        public Node(int value) {
            this.value = value;
        }

    }

    public SkipList(int[] nums, int interval) {
        head = new Node(-1);
        head.next = head;
        finalList = new ArrayList<>();
        initSkipList(nums, interval);
    }

    private void initSkipList(int[] nums, int interval) {
        if (nums == null || nums.length == 0) {
            return;
        }

        level = 0;
        // 默认升序
        Arrays.sort(nums);

        Node cur = head;
        for (int num : nums) {
            Node node = new Node(num);
            node.next = cur.next;
            node.prev = cur;
            cur.next = node;
            cur = node;
        }

        cur.next = head;
        cur.prev = null;
        finalList.add(cur);
        level++;
        while (level < nums.length) {
            cur = cur.next;
            finalList.add(cur);
            level++;
        }

        finalList.add(head);
    }

}
