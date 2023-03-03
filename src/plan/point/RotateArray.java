package plan.point;

/**
 * @author Real
 * @since 2023/3/3 19:54
 */
public class RotateArray {

    public static void main(String[] args) {

    }

    /**
     * 轮转数组，将数组往后面轮转多少位。所有的翻转
     * 从 k 开始，前面的数组翻转；后面的数组翻转
     *
     * @param nums 数组
     * @param k    k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        k %= length;

        rotateArray(nums, 0, length - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, length - 1);

    }

    private void rotateArray(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = start, j = end; i <= j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
