package hot100;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author wei.song
 * @since 2023/2/16 17:11
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int left = 0;
        int right = 0;
        int minLength = length + 1;

        long sum = 0;
        while (right < length) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(right - left + 1, minLength);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == length + 1 ? 0 : minLength;
    }

}
