package weekly_competition.date2022.date2022_11.week318;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 * <p>
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 * <p>
 * 子数组 是数组中一段连续非空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,4,2,9,9,9], k = 3
 * 输出：15
 * 解释：nums 中长度为 3 的子数组是：
 * - [1,5,4] 满足全部条件，和为 10 。
 * - [5,4,2] 满足全部条件，和为 11 。
 * - [4,2,9] 满足全部条件，和为 15 。
 * - [2,9,9] 不满足全部条件，因为元素 9 出现重复。
 * - [9,9,9] 不满足全部条件，因为元素 9 出现重复。
 * 因为 15 是满足全部条件的所有子数组中的最大子数组和，所以返回 15 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,4], k = 3
 * 输出：0
 * 解释：nums 中长度为 3 的子数组是：
 * - [4,4,4] 不满足全部条件，因为元素 4 出现重复。
 * 因为不存在满足全部条件的子数组，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * @author Real
 * Date: 2022/11/6 10:50
 */
public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 7, 8, 9};
        int k = 3;
        MaximumSubarraySum test = new MaximumSubarraySum();
        System.out.println(test.maximumSubarraySum(nums, k));
    }

    /**
     * 可以使用滑动窗口解决这个问题
     *
     * @param nums 数组
     * @param k    长度
     * @return 子数组和
     */
    public long maximumSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }
        long sum = 0;
        long tempSum = 0;
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            while (set.size() >= k || set.contains(num)) {
                set.remove(nums[index]);
                tempSum -= nums[index++];
            }
            set.add(num);
            tempSum += num;
            if (set.size() == k) {
                sum = Math.max(tempSum, sum);
            }
        }
        return sum;
    }

}
