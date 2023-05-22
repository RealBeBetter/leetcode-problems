package weekly.date202305.week346;

/**
 * 2698. 求一个整数的惩罚数
 *
 * @author Real
 * @since 2023/5/23 0:27
 */
public class FindPunishmentNumberInteger {

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int total = i * i;
            if (dfs(String.valueOf(total), i, 0, 0)) {
                ans += total;
            }
        }

        return ans;
    }

    private boolean dfs(String s, int targetSum, int index, int curSum) {
        if (index == s.length()) {
            return curSum == targetSum;
        }
        if (curSum > targetSum) {
            return false;
        }
        int tmpSum = 0;
        for (int i = index; i < s.length(); i++) {
            tmpSum = tmpSum * 10 + (s.charAt(i) - '0');
            if (dfs(s, targetSum, i + 1, curSum + tmpSum)) {
                return true;
            }
        }
        return false;
    }

}
