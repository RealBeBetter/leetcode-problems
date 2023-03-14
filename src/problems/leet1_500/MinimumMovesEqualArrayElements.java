package problems.leet1_500;

/**
 * @author Real
 * @since 2023/3/15 0:53
 */
public class MinimumMovesEqualArrayElements {

    /**
     * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1。
     * 返回让数组所有元素相等的最小操作次数。
     *
     * @param nums 数组
     * @return int
     */
    public int minMoves(int[] nums) {
        // 增加 n - 1 个 1，等于减少 1 个 1；则变为每个数字和 Min 的差值之和
        int min = nums[0];
        for (int j : nums) {
            min = Math.min(j, min);
        }

        int ans = 0;
        for (int num : nums) {
            ans += num - min;
        }

        return ans;
    }

}
