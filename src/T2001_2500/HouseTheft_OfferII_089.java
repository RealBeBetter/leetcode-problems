package T2001_2500;

/**
 * @ author : Real
 * @ date : 2021/10/28 21:18
 * @ description : 剑指Offer089——房屋偷盗
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组 nums，请计算不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Gu0c2T
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseTheft_OfferII_089 {
    // https://blog.csdn.net/fat_cai_niao/article/details/103008116
    public static int rob(int[] nums) {
        /*偷盗 n 座房子，那么盗窃的值有两种情况，最后一栋偷或者不偷。
        * n 栋房子，那么一共有0~n-1栋房子
        * 如果最后一栋偷，那么dp[n] = dp[n-2] + nums[n-1]
        * 如果最后一栋不偷，那么dp[n] = dp[n-1]
        * 主要思想就是将问题分解，然后递归求解
        * */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
