package problems.leet1001_1500;

/**
 * @ author : Real
 * @ date : 2021/10/30 18:51
 * @ description : 质数排列1175
 * 请你帮忙给从 1 到 n的数设计排列方案，使得所有的「质数」都应该被
 * 放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * 让我们一起来回顾一下「质数」：
 * 质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7之后的结果即可。
 * 示例 1：
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，
 * 但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 * 输入：n = 100
 * 输出：682289015
 * 限制：
 * 1 <= n <= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-arrangements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrimeArrangements_1175 {
    /**
     * 简单的题解：题目要求所有的质数放在【索引为质数的位置】，然后排列。
     * 先要算出质数，再求排列组合的个数，避免结果溢出
     * 排列组合的求法：A（M，N）从下往上的写法，计算的时候分为两部分，质数以及非质数，两个A相乘
     * 注意结果不要溢出，使用long保存
     *
     * @param n
     * @return
     */
    public static int numPrimeArrangements(int n) {
        final int MOD_NUMBER = 1000000007;
        /*int[] primeNumber = getPrimeNumber(n);
        int length = primeNumber.length;*/
        // 求解质数的长度
        int length = getPrimeCount(n);
        if (n <= 2) {
            return 1;
        }
        long ans = 1;
        for (int i = 1; i <= length; i++) {
            if (ans > MOD_NUMBER) {
                ans = ans % MOD_NUMBER;
            }
            ans *= i;
        }
        for (int i = 1; i <= n - length; i++) {
            if (ans > MOD_NUMBER) {
                ans = ans % MOD_NUMBER;
            }
            ans *= i;
        }
        return (int) (ans % MOD_NUMBER);
    }

    public static boolean isPrimeNumber(int n) {
        // 判断是否是质数
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            // 除了能被1和本身整除，其余的都不能整除
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 求质数的个数
    public static int getPrimeCount (int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrimeNumber(i)) {
                count++;
            }
        }
        return count;
    }

    // 求出 1 ~ n 之间的质数【优化一下只需要求出length即可】
    public static int[] getPrimeNumber(int n) {
        int[] primeNumber = new int[n];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrimeNumber(i)) {
                primeNumber[count++] = i;
            }
        }
        int[] ans = new int[count];
        for (int i = 0; i < count; i++) {
            ans[i] = primeNumber[i];
        }
        return ans;
    }



    public static void main(String[] args) {
        int n = 5;          // 12
        //System.out.println(numPrimeArrangements(5));
        int m1 = 100;       // 682289015
        int n1 = 682289015;
        System.out.println(numPrimeArrangements(m1));
    }
}
