package hot100;

/**
 * 75. 颜色分类
 *
 * @author Real
 * @since 2023/4/1 11:23
 */
public class SortColors {

    /**
     * 颜色分类，关注 0\1\2 的个数，依次覆盖 2 1 0 达到目标值
     *
     * @param nums 数组
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zero = 0, one = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            nums[i] = 2;

            if (num < 2) {
                nums[one++] = 1;
            }
            if (num < 1) {
                nums[zero++] = 0;
            }
        }
    }

}
