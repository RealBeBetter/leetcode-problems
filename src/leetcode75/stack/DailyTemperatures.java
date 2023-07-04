package leetcode75.stack;

/**
 * 739. 每日温度
 *
 * @author wei.song
 * @since 2023/7/4 14:35
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return temperatures;
        }

        int length = temperatures.length;
        int[] ans = new int[length];

        for (int i = length - 2; i >= 0; i--) {
            // 逆序从已经得到答案的结果中找
            for (int j = i + 1; j < length; j += ans[j]) {
                if (temperatures[i] < temperatures[j]) {
                    ans[i] = j - i;
                    break;
                }
                if (ans[j] == 0) {
                    ans[i] = 0;
                    break;
                }
            }
        }

        return ans;
    }

}
