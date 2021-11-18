package T1_500;

/**
 * @ author : Real
 * @ date : 2021/11/15 16:00
 * @ description : 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int maxCount = nums[0];
        int ans = maxCount;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + maxCount >= nums[i]) {
                maxCount = nums[i] + maxCount;
            } else {
                maxCount = nums[i];
            }
            if (maxCount > ans) {
                ans = maxCount;
            }
        }
        return ans;
    }
}
