package T501_1000;

import java.util.Arrays;

/**
 * @ author : Real
 * @ date : 2021/11/3 21:29
 * @ description : 795. 区间子数组个数
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 注意:
 * L, R 和A[i] 都是整数，范围在[0, 10^9]。
 * 数组A的长度范围在[1, 50000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfSubarraysWithBoundedMaximum_795 {
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 答案求个数，连续非空且其中最大的元素满足条件
        return calculate(nums, right) - calculate(nums, left - 1);
    }

    // 计算符合条件的数组个数
    public static int calculate(int[] nums, int bound) {
        int ans = 0, cur = 0;
        for (int x: nums) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }

    /*// 计算数组中的最大值
    public static int maxNumber(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }*/

    public static void main(String[] args) {
        int[] nums = {2, 9, 2, 5, 6};       // 7
        int[] nums2 = {2, 1, 4, 3};       // 3
//        System.out.println(numSubarrayBoundedMax(nums, 2, 8));
        System.out.println(numSubarrayBoundedMax(nums2, 2, 3));
    }
}
