package weekly_competition.date2023.date202302.week334;

import java.util.Arrays;

/**
 * 6369. 左右元素和的差值
 * 给你一个下标从 0 开始的整数数组 nums ，请你找出一个下标从 0 开始的整数数组 answer ，其中：
 * answer.length == nums.length
 * answer[i] = |leftSum[i] - rightSum[i]|
 * 其中：
 * leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 * rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回数组 answer 。
 * <p>
 * 示例 1：
 * 输入：nums = [10,4,8,3]
 * 输出：[15,1,11,22]
 * 解释：数组 leftSum 为 [0,10,14,22] 且数组 rightSum 为 [15,11,3,0] 。
 * 数组 answer 为 [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22] 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[0]
 * 解释：数组 leftSum 为 [0] 且数组 rightSum 为 [0] 。
 * 数组 answer 为 [|0 - 0|] = [0] 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 *
 * @author Real
 * @since 2023/2/26 10:32
 */
public class LeftAndRightSumDifferences {

    /**
     * 输出左侧元素和右侧元素差值的绝对值数组
     *
     * @param nums 数组
     * @return {@link int[]}
     */
    public int[] leftRigthDifference(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int length = nums.length;
        int[] ans = new int[length];

        long sum = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        long currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = calcSum(nums, i - 1);
            long currentRightSum = sum - currentSum - nums[i];
            ans[i] = (int) Math.abs(currentSum - currentRightSum);
        }

        return ans;
    }

    private long calcSum(int[] array, int end) {
        int length = array.length;
        long sum = 0;
        end = Math.min(end, length - 1);
        for (int i = 0; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }

}
