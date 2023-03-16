package introduction.array.change;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * @author Real
 * @since 2023/3/16 22:42
 */
public class MoveZeroes {

    /**
     * 移动零
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 双指针
        int nonZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            // 不为 0 则往该 index 后面加上
            if (nums[i] != 0) {
                if (nonZeroIndex != -1) {
                    nums[nonZeroIndex++] = nums[i];
                }
            } else {
                nonZeroIndex = nonZeroIndex == -1 ? i : nonZeroIndex;
            }
        }

        // 后面补齐 0
        while (nonZeroIndex != nums.length && nonZeroIndex != -1) {
            nums[nonZeroIndex++] = 0;
        }

    }

}
