package introduction.array.change;

/**
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * @author Real
 * @since 2023/3/15 13:00
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
    }

    public static boolean checkPossibility(int[] nums) {
        // 前面的数字 > 后面的数字，找到该数字，并查找长度
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }

        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            // 要变成递增序列
            flag++;
            if (i == 0) {
                nums[i] = nums[i + 1];
            } else {
                if (nums[i + 1] >= nums[i - 1]) {
                    // 1 3 2
                    nums[i] = nums[i - 1];
                } else {
                    // 3 4 2
                    nums[i + 1] = nums[i];
                }
            }
        }

        return flag <= 1;
    }

}
