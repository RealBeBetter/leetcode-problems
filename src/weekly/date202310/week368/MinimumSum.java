package weekly.date202310.week368;

/**
 * @author wei.song
 * @since 2023/10/22 10:33
 */
public class MinimumSum {

    public int minimumSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        int minSum = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        if (minSum == -1) {
                            minSum = nums[i] + nums[j] + nums[k];
                        }

                        minSum = Math.min(minSum, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }

        return minSum;
    }

}
