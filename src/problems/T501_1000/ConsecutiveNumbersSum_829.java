package problems.T501_1000;

/**
 * @ author : Real
 * @ date : 2021/11/1 20:46
 * @ description : 829. 连续整数求和
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 * 示例 1:
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 * 输入: 9
 * 输出: 3
 * 解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 * 输入: 15
 * 输出: 4
 * 解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 说明:1 <= N <= 10 ^ 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/consecutive-numbers-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConsecutiveNumbersSum_829 {
    public int consecutiveNumbersSum(int n) {
        // 求的是组数，应该从0开始，给定的是等差数列
        // 个数为1，则为自身
        // 个数为2，N - 1能整除2则表示存在
        // 个数为3，N - 1 - 2 能整除3则表示存在
        // 依次类推
        int ans = 0;
        for (int i = 1; n > 0 ; i++) {
            if (n % i == 0) {
                ans++;
            }
            n = n - i;
        }
        return ans;
    }
}
