package weekly.date202305.week344;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 6416. 找出不同元素数目差数组
 *
 * @author Real
 * @since 2023/5/7 10:31
 */
public class DistinctDifferenceArray {

    public static void main(String[] args) {
        DistinctDifferenceArray test = new DistinctDifferenceArray();
        System.out.println(Arrays.toString(test.distinctDifferenceArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(test.distinctDifferenceArray(new int[]{3, 2, 3, 4, 2})));
    }

    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> prefix = new HashSet<>();
        Set<Integer> suffix = new HashSet<>();
        int length = nums.length;

        int[] pre = new int[length];
        int[] suf = new int[length];

        for (int i = 0, j = length - 1; i < length && j >= 0; i++, j--) {
            prefix.add(nums[i]);
            if (j + 1 < length) {
                suffix.add(nums[j + 1]);
            }
            pre[i] = prefix.size();
            suf[j] = suffix.size();
        }

        int[] ans = new int[length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre[i] - suf[i];
        }

        return ans;
    }

}
