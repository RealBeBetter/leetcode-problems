package problems.leet501_1000;

import java.util.LinkedList;

/**
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * @author Real
 * @since 2023/3/15 0:11
 */
public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{2, 1, 3}));
    }

    /**
     * 找到最长递增子序列长度
     *
     * @param nums 数组
     * @return int
     */
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        LinkedList<Integer> increaseNumbers = new LinkedList<>();
        for (int num : nums) {
            if (!increaseNumbers.isEmpty() && increaseNumbers.getLast() >= num) {
                increaseNumbers.clear();
            }
            increaseNumbers.add(num);

            ans = Math.max(ans, increaseNumbers.size());
        }

        return ans;
    }

    public static int findLengthOfLCISByGreedy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int start = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }

            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }

}
