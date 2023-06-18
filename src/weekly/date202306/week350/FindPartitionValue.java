package weekly.date202306.week350;

import java.util.Arrays;

/**
 * 6890. 找出分区值
 *
 * @author wei.song
 * @since 2023/6/18 10:42
 */
public class FindPartitionValue {

    /**
     * 找到两个分区内最大值和最小值的差
     *
     * @param nums 数组
     * @return int
     */
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Math.abs(nums[1] - nums[0]);
        for (int i = 0, j = 1; i < nums.length && j < nums.length; i++, j++) {
            int temp = Math.abs(nums[j] - nums[i]);
            ans = Math.min(ans, temp);
        }

        return ans;
    }

}
