package T2001_2500;

/**
 * @ author : Real
 * @ date : 2021/10/28 2:04
 * @ description : 连分式化简
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。
 * 返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 * 示例 1：
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于"3"+ (1 / ("2" + (1 / ("0" + 1 / "2"))))。
 * 注意[26, 8], [-13, -4]都不是正确答案。
 * 示例 2：
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deep-dark-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeepDarkFraction_LCP2 {
    public static int[] fraction(int[] cont) {
        int[] ans = new int[2];
        for (int i = cont.length - 1; i >= 0; i--) {
            if (i == cont.length - 1) {
                ans[1] = cont[i];
                ans[0] = 1;
            } else {
                ans[0] = cont[i] * ans[1] + ans[0];
                // ans[1] 不变，之后倒数
                int swap = ans[0];
                ans[0] = ans[1];
                ans[1] = swap;
            }
        }
        // 最后还需要倒一次
        int swap = ans[0];
        ans[0] = ans[1];
        ans[1] = swap;
        // 最大公约数化简
        int min = Math.min(ans[0], ans[1]);
        for (int i = min; i > 0; i--) {
            if (ans[0] % i == 0 && ans[1] % i == 0) {
                ans[0] = ans[0] / i;
                ans[1] = ans[1] / i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {3, 2, 0, 2};
        int[] test1 = {0, 0, 3};
        int[] fraction = fraction(test1);
        System.out.println(fraction[0] + ", " + fraction[1]);
    }
}
