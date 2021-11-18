package T501_1000;

/**
 * @ author : Real
 * @ date : 2021/10/30 17:48
 * @ description : 非递减数列，665
 * 给你一个长度为n的整数数组，请你判断在 最多 改变 1 个元素的情况下，
 * 该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的：
 * 对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 提示：
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5<= nums[i] <= 10 ^ 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NonDecreasingArray_665 {
    public static boolean checkPossibility(int[] nums) {
        // 记录是否修改
        boolean modify = false;
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i <= nums.length - 2; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i == 0) {
                    modify = true;
                    nums[i] = nums[i + 1];
                } else {
                    // 满足修改分为两种情况，上凸或者下凹，上凸则i为修改的值，下凹则i+1为修改的值
                    // 上凸：{1, "7", 4, 5}
                    // 下凹：{5, 7, "1", 8}
                    if (!modify && nums[i] > nums[i - 1] && nums[i] > nums[i + 1] && nums[i - 1] <= nums[i + 1]) {
                        modify = true;
                        nums[i] = nums[i - 1];
                    } else if (i + 1 == nums.length - 1) {
                        // 下凹第一种，要判断 i + 1 是不是数组尾部，{5, 7, "1"}
                        nums[i + 1] = nums[nums.length - 1];
                        return !modify;
                    } else if (!modify && nums[i + 1] < nums[i] && nums[i + 1] < nums[i + 2] && nums[i] <= nums[i + 2]) {
                        // 下凹第二种，{5, 7, "1", 8}
                        nums[i + 1] = nums[i];
                        modify = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums1 = {5, 7, 1, 8};     // true
        int[] nums2 = {1, 7, 4, 5};     // true
        int[] nums3 = {3, 4, 2, 3};     // false
        int[] nums4 = {4, 2, 1};        // false
        int[] nums5 = {1,2,4,5,3};      // true
        System.out.println(checkPossibility(nums5));
    }
}
