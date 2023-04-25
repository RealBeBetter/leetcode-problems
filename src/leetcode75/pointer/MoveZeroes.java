package leetcode75.pointer;

/**
 * 283. 移动零
 *
 * @author Real
 * @since 2023/4/25 21:57
 */
public class MoveZeroes {

    /**
     * 将所有 0 移动至数组末尾
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        // 将不为 0 的数字依次移动到数组开始的部分，后续补足 0
        int pointer = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            if (pointer == -1) {
                pointer = 0;
            }
            nums[pointer++] = nums[i];
        }

        while (pointer != -1 && pointer < length) {
            nums[pointer++] = 0;
        }
    }


}
