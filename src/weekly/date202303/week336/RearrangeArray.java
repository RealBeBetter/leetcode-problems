package weekly.date202303.week336;

import java.util.Arrays;

/**
 * @author Real
 * @since 2023/3/12 10:39
 */
public class RearrangeArray {

    /**
     * 重排数组得到前缀和为正数的个数
     *
     * @param nums 数组
     * @return int
     */
    public int maxScore(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int length = nums.length;
        long sum = 0;
        int ans = 0;
        for (int i = length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum > 0) {
                ans++;
            }
        }

        return ans;
    }

}
