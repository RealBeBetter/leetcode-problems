package problems.leet2001_2500;

/**
 * @ author : Real
 * @ date : 2021/11/1 20:04
 * @ description :  剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，
 * 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，
 * 从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，
 * 因此最后剩下的数字是3。
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出:3
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出:2
 * 取值范围：（模拟法有超时的风险）
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TheLastRemainingNumberInTheCircle_Offer_62 {
    public int lastRemaining(int n, int m) {
        // 约瑟夫环，使用公式法求解
        return f(n, m);
    }

    // 每次淘汰 第 m % n 个元素
    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }
}
