package problems.leet1_500;

/**
 * @author : Real
 * @date : 2022/1/1 16:58
 * @description : 357. 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n 。
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNumbersWithUniqueDigits_357 {
    public static int countNumbersWithUniqueDigits(int n) {
        // 从两位数开始，要考虑高位的数字可选项
        // 第一位可选 9 个数字，第二位可选 9 个数字（除了高位的数字），第三位可选 8 个数字
        if (n == 0) {
            return 1;
        }
        n = Math.min(n, 10);
        int ans = 10, base = 9, sum = 9;
        for (int i = 1; i < n; ++i) {
            ans += sum *= base--;
        }
        return ans;
    }
}
