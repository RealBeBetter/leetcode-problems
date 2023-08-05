package problems.interview;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * <a href="https://leetcode.cn/problems/integer-break/">...</a>
 * <a href="https://leetcode.cn/problems/jian-sheng-zi-lcof/">...</a>
 *
 * @author wei.song
 * @since 2023/8/5 10:40
 */
public class CuttingRope {

    public static void main(String[] args) {
        CuttingRope test = new CuttingRope();
        System.out.println(test.cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

}
