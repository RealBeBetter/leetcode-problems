package plan.point;

import java.util.Arrays;

/**
 * @author Real
 * @since 2023/3/3 20:36
 */
public class TwoSumInputSortedArray {

    public static void main(String[] args) {
        int[] array = {-1, 0};
        System.out.println(Arrays.toString(twoSum(array, -1)));
    }

    /**
     * 两数之和满足 target 的下标值 + 1
     *
     * @param numbers 数字
     * @param target  目标
     * @return {@link int[]}
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{1, 1};
        }

        int length = numbers.length;
        for (int i = 0, j = length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{1, 1};
    }

}
