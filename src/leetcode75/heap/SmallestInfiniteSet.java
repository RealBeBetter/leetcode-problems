package leetcode75.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2336. 无限集中的最小数字
 * https://leetcode.cn/problems/smallest-number-in-infinite-set
 *
 * @author wei.song
 * @since 2023/6/18 9:57
 */
public class SmallestInfiniteSet {

    private final Queue<Integer> queue;

    public SmallestInfiniteSet() {
        int callCount = 1000;
        queue = new PriorityQueue<>();
        for (int i = 1; i <= callCount; i++) {
            queue.add(i);
        }
    }

    public int popSmallest() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public void addBack(int num) {
        if (queue.contains(num)) {
            return;
        }
        queue.add(num);
    }
}
