package problems.leet1_500;

/**
 * @ author : Real
 * @ date : 2021/10/30 16:16
 * @ description : 整数替换_397
 * 给定一个正整数n ，你可以做如下操作：
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 *
 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReplacement_397 {
    public static int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;  //  防止栈溢出
        }
        if (n <= 3) {
            return n - 1;
        }
        if (n % 2 == 0) {
            return integerReplacement(n  / 2) + 1;
        } else {
            // 为奇数，那么要考虑是n+1还是n-1
            return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
    }
}
