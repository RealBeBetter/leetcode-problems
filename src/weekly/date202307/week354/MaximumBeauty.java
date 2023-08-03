package weekly.date202307.week354;

import java.util.Arrays;

/**
 * 6929. 数组的最大美丽值
 * <a href="https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation">...</a>
 *
 * @author wei.song
 * @since 2023/7/16 10:34
 */
public class MaximumBeauty {

    public static void main(String[] args) {
        MaximumBeauty test = new MaximumBeauty();
        int[] array = {4, 6, 1, 2};
        System.out.println(test.maximumBeauty(array, 2));
        int[] array2 = {1, 1, 1, 1};
        System.out.println(test.maximumBeauty(array2, 2));
    }


    /**
     * 最大美丽值
     *
     * @param nums nums
     * @param k    k
     * @return int
     */
    public int maximumBeauty(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;

        int preMax = nums[0] + k;

        while (right < nums.length) {
            if (nums[right] - k > preMax) {
                left++;
                preMax = nums[left] + k;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

}
