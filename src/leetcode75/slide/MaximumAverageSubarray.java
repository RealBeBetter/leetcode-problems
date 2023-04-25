package leetcode75.slide;

/**
 * 643. 子数组最大平均数 I
 *
 * @author Real
 * @since 2023/4/25 22:55
 */
public class MaximumAverageSubarray {

    public static void main(String[] args) {
        MaximumAverageSubarray test = new MaximumAverageSubarray();
        int[] nums = {-1};
        System.out.println(test.findMaxAverage(nums, 1));
    }

    /**
     * 找到数组中长度为 k 的连续子数组的最大平均数
     *
     * @param nums 数组
     * @param k    k
     * @return double
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAverage = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            maxAverage = Math.max(maxAverage, sum / k);
        }

        return maxAverage;
    }

}
