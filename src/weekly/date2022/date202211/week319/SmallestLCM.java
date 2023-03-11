package weekly.date2022.date202211.week319;

/**
 * 最小公倍数为 K 的子数组数目
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的 子数组 中满足 元素最小公倍数为 k 的子数组数目。
 * 子数组 是数组中一个连续非空的元素序列。
 * 数组的最小公倍数 是可被所有数组元素整除的最小正整数。
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：nums = [3,6,2,7,1], k = 6
 * 输出：4
 * 解释：以 6 为最小公倍数的子数组是：
 * - [3,6,2]
 * - [3,6]
 * - [6]
 * - [6,2]
 * 示例 2 ：
 * <p>
 * 输入：nums = [3], k = 2
 * 输出：0
 * 解释：不存在以 2 为最小公倍数的子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], k <= 1000
 * https://leetcode.cn/contest/weekly-contest-319/problems/number-of-subarrays-with-lcm-equal-to-k/
 *
 * @author Real
 * Date: 2022/11/13 10:51
 */
public class SmallestLCM {

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 7, 1};
        int target = 6;
        SmallestLCM test = new SmallestLCM();
        System.out.println(test.subarrayLCM(nums, target));
    }

    /**
     * 找出最小公倍数为 k 的子数组个数
     *
     * @param nums 数组
     * @param k    target
     * @return 符合条件的数组个数
     */
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = i; j < n; j++) {
                x = lcm(x, nums[j]);
                if (x == k) ans++;
                else if (x > k) break;
            }
        }
        return ans;
    }

    public int gcd(int b, int a) {
        return a != 0 ? gcd(a, b % a) : b;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
