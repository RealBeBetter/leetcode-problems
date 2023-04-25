package leetcode75.array;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author wei.song
 * @since 2023/4/25 16:10
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf test = new ProductExceptSelf();
        int[] array = {-1, 1, 0, -3, 3};
        int[] nums = test.productExceptSelf(array);
        System.out.println(Arrays.toString(nums));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];

        prefix[0] = nums[0];
        suffix[length - 1] = nums[length - 1];

        for (int i = 1, j = length - 2; i < length && j >= 0; i++, j--) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[j] = suffix[j + 1] * nums[j];
        }

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                nums[i] = suffix[i + 1];
            } else if (i == length - 1) {
                nums[i] = prefix[i - 1];
            } else {
                nums[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return nums;
    }

}
