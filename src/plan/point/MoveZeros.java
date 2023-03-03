package plan.point;

import java.util.Arrays;

/**
 * @author Real
 * @since 2023/3/3 20:12
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 移动零至数组末尾，双指针，一个指向填充位置，一个指向遍历位置，末尾填充 0
     *
     * @param nums 数组
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zeroIndex = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 前面存在 0，即开始移动
            if (nums[i] != 0) {
                if (zeroIndex != -1) {
                    nums[zeroIndex++] = nums[i];
                }
            } else {
                zeroIndex = zeroIndex == -1 ? i : zeroIndex;
            }
        }

        while (zeroIndex != -1 && zeroIndex < length) {
            nums[zeroIndex++] = 0;
        }
    }

}
