package problems.leet2001_2500;

/**
 * @ author : Real
 * @ date : 2021/10/28 1:58
 * @ description :
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，
 * 小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。
 * guess和answer的长度都等于3。
 * 示例 1：
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GuessNumbers_LCP1 {
    public int game(int[] guess, int[] answer) {
        int ans = 0;
        for (int i = 0; i < guess.length; i++) {
            if (answer[i] == guess[i]) {
                ans++;
            }
        }
        return ans;
    }
}
