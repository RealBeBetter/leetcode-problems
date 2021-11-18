package T501_1000;

/**
 * @ author : Real
 * @ date : 2021/10/30 16:37
 * @ description : 第 n 个神奇数字
 * 如果正整数可以被 A 或 B 整除，那么它是神奇的。
 * 返回第 N 个神奇数字。由于答案可能非常大，返回它模10^9 + 7的结果。
 *
 * 示例 1：
 * 输入：N = 1, A = 2, B = 3
 * 输出：2
 *
 * 示例2：
 * 输入：N = 4, A = 2, B = 3
 * 输出：6
 *
 * 提示：
 * 1 <= N<= 10^9
 * 2 <= A<= 40000
 * 2 <= B<= 40000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-magical-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthMagicalNumber_878 {
    // 最小公倍数 Least Common Multiple = 两数乘积 / 最大公约数 Greatest Common Divisor

    /**
     * 设 L 为 A，B 的最小公倍数，如果 X ≤ L 是神奇数字，那么 X + L 也是神奇数字.
     * 有 M = L/A + L/B - 1个神奇数字小于等于 L：
     * 其中 L/A 个是能被A整除的，L/B个能被 B整除，1个能同时被 A，B 整除。
     * 设 N = M * q + r (r < M)，前L * q 个数字有M * q个神奇数字，（L*q+1，L*q+2，...）之间有
     * r个神奇数字。可以暴力搜素r，下一个神奇数字要么是 L * q + A，要么是L* q + B。以此类推。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/nth-magical-number/solution/di-n-ge-shen-qi-shu-zi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @param a
     * @param b
     * @return
     */
    public static int nthMagicalNumber(int n, int a, int b) {
        final int MOD = 1000000007;
        int L = a * b / gdc(a, b);
        int M = L/a + L/b - 1;
        int q = n / M;
        int r = n % M;
        long ans = (long) q * L % MOD;
        if (r == 0)
            return (int) ans;

        int[] heads = new int[]{a, b};
        for (int i = 0; i < r - 1; ++i) {
            if (heads[0] <= heads[1])
                heads[0] += a;
            else
                heads[1] += b;
        }

        ans += Math.min(heads[0], heads[1]);
        return (int) (ans % MOD);
    }

    public static int gdc (int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // 判断数字 n 是否能被 a 或 b 整除
    public static boolean canBeDivided (int n, int a, int b) {
        return n % a == 0 || n % b == 0;
    }

    public static void main(String[] args) {

    }
}
