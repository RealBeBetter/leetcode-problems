package leetcode75.dp;

/**
 * 746. 使用最小花费爬楼梯
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs">...</a>
 *
 * @author wei.song
 * @since 2023/6/18 10:15
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] minCost = new int[length + 1];
        minCost[0] = 0;
        minCost[1] = 0;

        for (int i = 2; i <= length; i++) {
            minCost[i] = Math.min(minCost[i - 2] + cost[i - 2], minCost[i - 1] + cost[i - 1]);
        }

        return minCost[length];
    }

}
