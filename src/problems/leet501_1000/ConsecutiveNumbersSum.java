package problems.leet501_1000;

/**
 * 829. 连续整数求和
 * https://leetcode-cn.com/problems/consecutive-numbers-sum
 *
 * @author Real
 * @date 2021/11/1 20:46
 */
public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int n) {
        // 求的是组数，应该从0开始，给定的是等差数列
        // 个数为1，则为自身
        // 个数为2，N - 1能整除2则表示存在
        // 个数为3，N - 1 - 2 能整除3则表示存在
        int ans = 0;
        for (int i = 1; n > 0; i++) {
            if (n % i == 0) {
                ans++;
            }
            n = n - i;
        }
        return ans;
    }

}
