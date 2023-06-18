package leetcode75.dp;

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber
 *
 * @author wei.song
 * @since 2023/6/18 10:23
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] robber = new int[nums.length];
        robber[0] = nums[0];
        robber[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            robber[i] = Math.max(robber[i - 1], robber[i - 2] + nums[i]);
        }

        return robber[nums.length - 1];
    }

}
