package weekly.date202303.biweek101;

import java.util.Arrays;

/**
 * 6329. 使子数组元素和相等
 *
 * @author Real
 * @since 2023/4/1 23:07
 */
public class MakeSubarraySumsEqual {

    /**
     * 使得每个长度为 k 的 子数组 的元素总和都相等，最小操作的次数
     * 单次操作只能 ±1，返回最小的操作次数
     *
     * @param arr 数组
     * @param k   k
     * @return long
     */
    public long makeSubKSumEqual(int[] arr, int k) {
        int length = arr.length;
        int gcd = gcd(length, k);
        long operations = 0;
        for (int i = 0; i < gcd; i++) {
            int[] arr2 = new int[length / gcd];
            for (int j = 0; j < arr2.length; j++) {
                arr2[j] = arr[j * gcd + i];
            }
            Arrays.sort(arr2);
            for (int value : arr2) {
                operations += Math.abs(value - arr2[arr2.length / 2]);
            }
        }
        return operations;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
