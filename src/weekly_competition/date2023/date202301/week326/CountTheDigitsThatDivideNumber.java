package weekly_competition.date2023.date202301.week326;

/**
 * 6278. 统计能整除数字的位数
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 * <p>
 * 示例 1：
 * 输入：num = 7
 * 输出：1
 * 解释：7 被自己整除，因此答案是 1 。
 * 示例 2：
 * 输入：num = 121
 * 输出：2
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * 示例 3：
 * 输入：num = 1248
 * 输出：4
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 * <p>
 * 提示：
 * 1 <= num <= 109
 * num 的数位中不含 0
 *
 * @author wei.song
 * @since 2023/1/1 18:38
 */
public class CountTheDigitsThatDivideNumber {


    /**
     * 统计数字
     * 进阶版做法：使用 Map 统计每个符合条件的数字条件
     * 如果重复的数字，直接返回 value + 1，避免重复计算
     *
     * @param num 数字
     * @return int
     */
    public int countDigits(int num) {
        int temp = num;
        int ans = 0;
        while (temp > 0) {
            int digit = temp % 10;
            if (num % digit == 0) {
                ans++;
            }
            temp = temp / 10;
        }
        return ans;
    }

}
