package problems.leet501_1000;

/**
 * 739. 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 *
 * @author wei.song
 * @since 2023/6/3 10:44
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];

        for (int i = temperatures.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < temperatures.length; j += ans[j]) {
                if (temperatures[i] < temperatures[j]) {
                    ans[i] = j - i;
                    break;
                } else if (ans[j] == 0) {
                    ans[i] = 0;
                    break;
                }
            }
        }

        return ans;
    }

}
