package weekly.date2023.date202302.week332;

import java.util.Arrays;

/**
 * 6355. 统计公平数对的数目
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 * 0 <= i < j < n，且
 * lower <= nums[i] + nums[j] <= upper
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * 输出：6
 * 解释：共计 6 个公平数对：(0,3)、(0,4)、(0,5)、(1,3)、(1,4) 和 (1,5) 。
 * 示例 2：
 * 输入：nums = [1,7,9,2,5], lower = 11, upper = 11
 * 输出：1
 * 解释：只有单个公平数对：(2,3) 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * nums.length == n
 * -109 <= nums[i] <= 109
 * -109 <= lower <= upper <= 109
 *
 * @author wei.song
 * @since 2023/2/12 10:59
 */
public class CountFairPairs {

    public static void main(String[] args) {
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3, upper = 6;
        CountFairPairs test = new CountFairPairs();
        System.out.println(test.countFairPairsBySort(nums, lower, upper));
    }

    /**
     * 算公平对，即数组中两个不同下标的值之和在 [lower, upper] 之间
     *
     * @param nums  数字
     * @param lower 较低值
     * @param upper 较大值
     * @return long公平数对的个数
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        // 暴力枚举
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int tempSum = nums[i] + nums[j];
                if (tempSum >= lower && tempSum <= upper) {
                    count++;
                }
            }
        }

        return count;
    }


    public long countFairPairsBySort(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0, j = nums.length - 1, k = nums.length - 1; i < nums.length; i++) {
            // 找到第一个 >= lower 的前一个位置
            for (; j >= 0 && nums[i] + nums[j] >= lower; j--) {
            }
            // 找到第一个 <= upper 的位置
            for (; k >= 0 && nums[i] + nums[k] > upper; k--) {
            }
            // 若定位的 i 夹在 j、k 之间，则会多统计一次 (i,i) 数对，故要 -1
            count += k - j - (i > j && i <= k ? 1 : 0);
        }
        // 数对，每个数对统计了两次
        return count / 2;
    }

    /**
     * 后项遍历，前指针移动，运行完毕前向指针移动一个下标
     *
     * @param nums  数组
     * @param lower 较低
     * @param upper 较大
     * @return long
     */
    private long countFairPairsByNext(int[] nums, int lower, int upper) {
        long count = 0;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                long tempSum = nums[i] + nums[j];
                if (tempSum >= lower && tempSum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

}
