package problems.leet501_1000;

/**
 * @ author : Real
 * @ date : 2021/11/15 17:57
 * @ description : 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
 * 都有 nums[i] < nums[i + 1] ，
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
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestContinuousIncreasingSubsequence_674 {

    // 计算最长递增序列长度
    public static int findLengthOfLCIS(int[] nums) {
        // 方法一：直接递归解决，遇到不符合条件的就重置临时值
        /*if (nums.length == 0) {
            return 0;
        }
        int ans = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp++;
            } else {
                temp = 1;
            }
            ans = Math.max(temp, ans);
        }
        return ans;*/


        // 方法二：使用动态规划解决
        // 动态规划定义：dp[i] 表示以 nums[i] 结尾的数组最长的递增子串长度
        // 动态规划转移：dp[i] = dp[i-1] + 1 (nums[i] > nums[i-1]) // dp[i] = 1
        // 动态规划初始：dp[0] = 1;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,4,7};      // 3
        System.out.println(findLengthOfLCIS(array));

    }

}
