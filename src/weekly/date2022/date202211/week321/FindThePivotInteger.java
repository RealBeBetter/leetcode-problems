package weekly.date2022.date202211.week321;

/**
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 * <p>
 * 示例 1：
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * 示例 3：
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 * <p>
 * 提示：
 * 1 <= n <= 1000
 *
 * @author Real
 * Date: 2022/11/27 10:44
 */
public class FindThePivotInteger {

    public static void main(String[] args) {
        FindThePivotInteger test = new FindThePivotInteger();
        System.out.println(test.pivotInteger(4));
    }

    public int pivotInteger(int n) {
        if (n <= 1) {
            return n;
        }
        long[] sum = new long[n + 1];
        sum[0] = 1;
        sum[1] = 1;
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + i;
        }
        long maxSum = sum[n];
        for (int i = n / 2; i <= n; i++) {
            if (sum[i] == maxSum - sum[i - 1]) {
                return i;
            }
        }
        return -1;
    }
}
