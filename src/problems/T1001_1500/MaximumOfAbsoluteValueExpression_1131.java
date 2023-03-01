package problems.T1001_1500;

/**
 * @ author : Real
 * @ date : 2021/11/16 16:59
 * @ description : 1131. 绝对值表达式的最大值
 * 给你两个长度相等的整数数组，返回下面表达式的最大值：
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 * 其中下标 i，j 满足 0 <= i, j < arr1.length。
 * 示例 1：
 * 输入：arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * 输出：13
 * 示例 2：
 * 输入：arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * 输出：20
 * <p>
 * 提示：
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-of-absolute-value-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumOfAbsoluteValueExpression_1131 {

    public static int maxAbsValExpr(int[] arr1, int[] arr2) {
        int amin = Integer.MAX_VALUE, bmin = Integer.MAX_VALUE, cmin = Integer.MAX_VALUE, dmin = Integer.MAX_VALUE;
        int amax = Integer.MIN_VALUE, bmax = Integer.MIN_VALUE, cmax = Integer.MIN_VALUE, dmax = Integer.MIN_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            amin = Math.min(amin, arr1[i] + arr2[i] + i);
            amax = Math.max(amax, arr1[i] + arr2[i] + i);

            bmin = Math.min(bmin, arr1[i] + arr2[i] - i);
            bmax = Math.max(bmax, arr1[i] + arr2[i] - i);

            cmin = Math.min(cmin, arr1[i] - arr2[i] + i);
            cmax = Math.max(cmax, arr1[i] - arr2[i] + i);

            dmin = Math.min(dmin, arr1[i] - arr2[i] - i);
            dmax = Math.max(dmax, arr1[i] - arr2[i] - i);
        }

        return Math.max(Math.max(amax - amin, bmax - bmin), Math.max(cmax - cmin, dmax - dmin));

    }

}
