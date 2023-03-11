package problems.leet2001_2500;

import java.util.Arrays;

/**
 * @ author : Real
 * @ date : 2021/10/30 17:15
 * @ description : 面试题16.06最小差
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），
 * 并返回该对数值的差
 * 示例：
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 * 提示：
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间 [0, 2147483647] 内
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-difference-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestDifferenceLCCI_M16_06 {
    /**
     * 解题思路：排序+双指针，长度10w，排序是可行的
     * 双指针，分别移动，直至两个数组都走完，循环截止
     * 指针移动的条件：小的一方移动，直至小的一方大于或等于（直接返回）大的一方，大的一方才移动
     * 总之就是移动先小的一方，直至其中一方走完
     * 要注意int存储绝对值溢出的情况，直接使用long存储
     * @param a
     * @param b
     * @return
     */
    public static int smallestDifference(int[] a, int[] b) {
        // 算最小值，初始值应最大，为防止溢出现象，使用long存储
        long ans = Integer.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        while (i != a.length && j != b.length) {
            long temp = Math.abs(a[i] - b[j]);
            ans = Math.min(Math.abs(temp), Math.abs(ans));
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                // 相等，直接返回0
                return 0;
            }

        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};
        int[] c = {-2147483648,1};
        int[] d = {2147483647,0};
        System.out.println(smallestDifference(c, d));
    }
}
