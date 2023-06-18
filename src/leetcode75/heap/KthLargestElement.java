package leetcode75.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author wei.song
 * @since 2023/6/18 9:51
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

}
