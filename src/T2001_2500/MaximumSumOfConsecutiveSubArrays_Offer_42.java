package T2001_2500;

/**
 * @ author : Real
 * @ date : 2021/11/15 17:37
 * @ description : 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * <p>
 * 提示：
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSumOfConsecutiveSubArrays_Offer_42 {

    public static int maxSubArray(int[] nums) {
        // 动态规划解题
        if (nums.length == 0) {
            return 0;
        }
        // 三个步骤
        // 动态数组定义：dp[i] 表示以 nums[i] 结尾的和最大的连续子数组的和
        // 动态转移方程：dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
        // 初始化状态：dp[0] = nums[0]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));     // 6
    }

}
