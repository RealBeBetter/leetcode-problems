package leetcode75.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2542. 最大子序列的分数
 * <a href="https://leetcode.cn/problems/maximum-subsequence-score">2542. 最大子序列的分数</a>
 *
 * @author wei.song
 * @since 2023/7/4 16:34
 */
public class MaximumSubsequenceScore {

    public static void main(String[] args) {
        int[] num1 = {2, 1, 14, 12};
        int[] num2 = {11, 7, 13, 6};
        MaximumSubsequenceScore test = new MaximumSubsequenceScore();
        System.out.println(test.maxScore(num1, num2, 3));
    }

    /**
     * 最高得分，前面 sum，后面 min，求最大积
     *
     * @param nums1 nums1
     * @param nums2 nums2
     * @param k     k
     * @return long
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long maximumScore = 0;
        int length = nums1.length;

        int[][] nums = new int[length][2];
        for (int i = 0; i < length; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }

        Arrays.sort(nums, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < length; i++) {
            if (i >= k) {
                int prev = queue.poll();
                sum -= prev;
            }
            int[] arr = nums[i];
            queue.offer(arr[0]);
            sum += arr[0];
            if (i >= k - 1) {
                long currScore = sum * arr[1];
                maximumScore = Math.max(maximumScore, currScore);
            }
        }
        return maximumScore;
    }

}
