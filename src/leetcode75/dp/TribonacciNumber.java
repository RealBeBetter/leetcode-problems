package leetcode75.dp;

/**
 * 1137. 第 N 个泰波那契数
 * https://leetcode.cn/problems/n-th-tribonacci-number
 *
 * @author wei.song
 * @since 2023/6/18 10:09
 */
public class TribonacciNumber {

    public int tribonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 1;

        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 3] + array[i - 2] + array[i - 1];
        }

        return array[n];
    }

}
