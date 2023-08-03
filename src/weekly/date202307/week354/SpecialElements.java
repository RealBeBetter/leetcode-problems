package weekly.date202307.week354;

/**
 * 6889. 特殊元素平方和
 * <a href="https://leetcode.cn/problems/sum-of-squares-of-special-elements/">...</a>
 *
 * @author wei.song
 * @since 2023/7/16 10:30
 */
public class SpecialElements {

    public int sumOfSquares(int[] nums) {
        int ans = 0;
        int length = nums.length;
        for (int i = 1; i <= nums.length; i++) {
            if (length % i == 0) {
                ans += nums[i - 1] * nums[i - 1];
            }
        }

        return ans;
    }

}
