package leetcode75.prefix;

/**
 * 724. 寻找数组的中心下标
 *
 * @author Real
 * @since 2023/4/27 22:38
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        int[] suffix = new int[nums.length + 1];

        for (int i = 0, j = nums.length - 1; i < nums.length && j > 0; i++, j--) {
            prefix[i + 1] = prefix[i] + nums[i];
            suffix[j - 1] = suffix[j] + nums[j];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefix[i] == suffix[i]) {
                return i;
            }
        }

        return -1;
    }

}
