package weekly_competition.date2022.date2022_10.week317;

/**
 * 给你两个正整数 n 和 target 。
 * <p>
 * 如果某个整数每一位上的数字相加小于或等于 target ，则认为这个整数是一个 美丽整数 。
 * <p>
 * 找出并返回满足 n + x 是 美丽整数 的最小非负整数 x 。生成的输入保证总可以使 n 变成一个美丽整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 16, target = 6
 * 输出：4
 * 解释：最初，n 是 16 ，且其每一位数字的和是 1 + 6 = 7 。在加 4 之后，n 变为 20 且每一位数字的和变成 2 + 0 = 2 。可以证明无法加上一个小于 4 的非负整数使 n 变成一个美丽整数。
 * 示例 2：
 * <p>
 * 输入：n = 467, target = 6
 * 输出：33
 * 解释：最初，n 是 467 ，且其每一位数字的和是 4 + 6 + 7 = 17 。在加 33 之后，n 变为 500 且每一位数字的和变成 5 + 0 + 0 = 5 。可以证明无法加上一个小于 33 的非负整数使 n 变成一个美丽整数。
 * 示例 3：
 * <p>
 * 输入：n = 1, target = 1
 * 输出：0
 * 解释：最初，n 是 1 ，且其每一位数字的和是 1 ，已经小于等于 target 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1012
 * 1 <= target <= 150
 * 生成的输入保证总可以使 n 变成一个美丽整数。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-addition-to-make-integer-beautiful
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wei.song
 * @since 2022-10-31 13:08
 */
public class MinimumAdditionToMakeIntegerBeautiful2457 {

    public long makeIntegerBeautiful(long n, int target) {
        if (isBeautifulNumber(n, target)) return 0L;
        long k = 10;
        while (true) {
            long temp = (n / k + 1) * k;
            if (isBeautifulNumber(temp, target)) {
                return temp - n;
            }
            k *= 10;
        }
    }

    public int getEveryCount(long n) {
        int count = 0;
        while (n >= 10) {
            int number = (int) (n % 10);
            n /= 10;
            count += number;
        }
        count += n;
        return count;
    }

    public boolean isBeautifulNumber(long n, int target) {
        int count = getEveryCount(n);
        return count <= target;
    }

}
