package leetcode75.pointer;

import java.util.Arrays;

/**
 * 1679. K 和数对的最大数目
 *
 * @author Real
 * @since 2023/4/25 22:50
 */
public class MaxNumberSumPairs {

    /**
     * 从数组中选出和为 k 的两个整数，并将它们移出数组。
     * 返回你可以对数组执行的最大操作数。
     *
     * @param nums 数组
     * @param k    k
     * @return int
     */
    public int maxOperations(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int operations = 0;
        int length = nums.length;
        for (int i = 0, j = length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (sum > k) {
                j--;
            } else if (sum < k) {
                i++;
            } else {
                i++;
                j--;
                operations++;
            }
        }

        return operations;
    }

}
