package weekly_competition.date2023_01.week327;

/**
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-3,-2,-1,0,0,1,2]
 * 输出：3
 * 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,20,66,1314]
 * 输出：4
 * 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * -2000 <= nums[i] <= 2000
 * nums 按 非递减顺序 排列。
 *
 * @author wei.song
 * @since 2023/1/8 11:58
 */
public class MaximumCount {

    /**
     * 最大数
     *
     * @param nums 给定的数组
     * @return int
     */
    public int maximumCount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int negative = 0;
        int zero = 0;
        for (int num : nums) {
            if (num < 0) {
                negative++;
            } else if (num == 0) {
                zero++;
            } else {
                break;
            }
        }
        return Math.max(negative, nums.length - zero - negative);
    }

}
