package offer.special.math;

/**
 * 剑指 Offer II 001. 整数除法
 * 简单
 * 196
 * 相关企业
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 * <p>
 * 示例 1：
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 * 输入：a = 1, b = 1
 * 输出：1
 * <p>
 * 提示:
 * -231 <= a, b <= 231 - 1
 * b != 0
 *
 * @author Real
 * Date: 2022/11/6 17:27
 */
public class IntegerDivision {

    public static void main(String[] args) {
        IntegerDivision test = new IntegerDivision();
        System.out.println(test.divide(100, 10));
    }

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // 环境只支持存储 32 位整数
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        // 因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }

}
