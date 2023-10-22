package weekly.date202310.week368;

/**
 * @author wei.song
 * @since 2023/10/22 10:38
 */
public class MinimumSumII {

    public static void main(String[] args) {
        MinimumSumII minimumSum = new MinimumSumII();
        int[] nums = {5, 4, 8, 7, 10, 2};
        System.out.println(minimumSum.minimumSum(nums));
    }

    public int minimumSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        // 前缀最小值，后缀最小值
        int length = nums.length;
        int[] prefixMinArray = new int[length];
        prefixMinArray[0] = nums[0];
        int[] suffixMinArray = new int[length];
        suffixMinArray[length - 1] = nums[length - 1];
        for (int i = 1, j = length - 2; i < length - 1 && j > 0; i++, j--) {
            prefixMinArray[i] = Math.min(nums[i], prefixMinArray[i - 1]);
            suffixMinArray[j] = Math.min(nums[j], suffixMinArray[j + 1]);
        }

        int minSum = -1;
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > prefixMinArray[i - 1] && nums[i] > suffixMinArray[i + 1]) {
                if (minSum == -1) {
                    minSum = nums[i] + prefixMinArray[i - 1] + suffixMinArray[i + 1];
                }
                minSum = Math.min(minSum, nums[i] + prefixMinArray[i - 1] + suffixMinArray[i + 1]);
            }
        }

        return minSum;
    }

}
