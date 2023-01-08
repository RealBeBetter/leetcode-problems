package weekly_competition.date2022.date2022_12.week323;

import java.util.Arrays;

/**
 * 6258. 数组中最长的方波
 * 给你一个整数数组 nums 。如果 nums 的子序列满足下述条件，则认为该子序列是一个 方波 ：
 * 子序列的长度至少为 2 ，并且
 * 将子序列从小到大排序 之后 ，除第一个元素外，每个元素都是前一个元素的 平方 。
 * 返回 nums 中 最长方波 的长度，如果不存在 方波 则返回 -1 。
 * 子序列 也是一个数组，可以由另一个数组删除一些或不删除元素且不改变剩余元素的顺序得到。
 * <p>
 * 示例 1 ：
 * 输入：nums = [4,3,6,16,8,2]
 * 输出：3
 * 解释：选出子序列 [4,16,2] 。排序后，得到 [2,4,16] 。
 * - 4 = 2 * 2.
 * - 16 = 4 * 4.
 * 因此，[4,16,2] 是一个方波.
 * 可以证明长度为 4 的子序列都不是方波。
 * 示例 2 ：
 * 输入：nums = [2,3,5,6,7]
 * 输出：-1
 * 解释：nums 不存在方波，所以返回 -1 。
 * <p>
 * 提示：
 * 2 <= nums.length <= 105
 * 2 <= nums[i] <= 105
 *
 * @author Real
 * @since 2022/12/11 11:22
 */
public class LongestSquareStreakInAnArray {

    public static void main(String[] args) {
        int[] nums1 = {5, 12, 3, 10, 4, 11, 4, 16, 11};      // 2
        int[] nums2 = {4, 3, 6, 16, 8, 2};                   // 3
        int[] nums3 = {4, 16, 256, 65536};                   // 4
//        System.out.println(longestSquareStreak(nums1));
//        System.out.println(longestSquareStreak(nums2));
        System.out.println(longestSquareStreak(nums3));
    }

    /**
     * 我们可以用一个数组 dp 来表示以每个元素为结尾的最长方波的长度。
     * 对于一个元素 nums[i]，我们要求 dp[i]，首先，如果 nums[i] 是一个完美的平方数，
     * 那么可以枚举每一个 j < i，如果 nums[i] 是 nums[j] 的完美平方，并且 dp[j] > 0，那么 dp[i] = dp[j] + 1。
     * 最后，我们只需要在 dp 数组中找到最大值即可。如果 dp 数组中没有任何一个元素的值大于 0，
     * 说明 nums 数组中没有方波，应该返回 -1。
     * <p>
     * <p>
     * 此方法超时，建议直接选择使用数组元素值作为下标
     *
     * @param nums 数组
     * @return 长度
     */
    public static int longestSquareStreakTimeOut(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int length = nums.length;

        // dp[i] 表示以 nums[i] 为结尾的最长方波的长度
        int[] dp = new int[length];
        // 枚举每个元素
        for (int i = 0; i < length; i++) {
            // 如果 nums[i] 是一个完美平方数，那么可以枚举每一个 j < i
            int sqrt = (int) Math.sqrt(nums[i]);
            if (sqrt * sqrt == nums[i]) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == sqrt && dp[j] > 0) {
                        dp[i] = dp[j] + 1;
                        break;
                    }
                }
            }
            dp[i] = dp[i] == 0 ? 1 : dp[i];
        }

        // 找出 dp 数组中的最大值
        int max = 1;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, dp[i]);
        }

        // 如果 dp 数组中没有任何一个元素的值大于 0，说明 nums 数组中没有方波，应该返回 -1
        return max > 1 ? max : -1;
    }

    public static int longestSquareStreak(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int maxElement = nums[length - 1];
        // dp[i] 表示以 nums[i] 为结尾的最长方波的长度
        int[] dp = new int[maxElement + 1];
        for (int k : nums) {
            dp[k] = 1;
        }
        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                dp[num] = dp[sqrt] + 1;
            }
        }
        // 找出最大长度
        int len = 1;
        for (int j : dp) {
            len = Math.max(len, j);
        }

        // 如果 dp 数组中没有任何一个元素的值大于 0，说明 nums 数组中没有方波，应该返回 -1
        return len > 1 ? len : -1;
    }

}
