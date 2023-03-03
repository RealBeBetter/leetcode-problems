package plan.point;

/**
 * @author Real
 * @since 2023/3/3 0:51
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {

    }

    /**
     * 排序平方数，使用双指针，利用新数组完成
     *
     * @param nums 数组
     * @return {@link int[]}
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int length = nums.length;
        int[] ans = new int[length];
        int point = length - 1;
        for (int i = 0, j = length - 1; i <= j; ) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[point--] = nums[i] * nums[i];
                i++;
            } else {
                ans[point--] = nums[j] * nums[j];
                j--;
            }
        }

        return ans;
    }

}
