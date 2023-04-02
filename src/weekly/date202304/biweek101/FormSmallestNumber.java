package weekly.date202304.biweek101;

/**
 * 6327. 从两个数字数组里生成最小数字
 *
 * @author Real
 * @since 2023/4/1 22:31
 */
public class FormSmallestNumber {

    public int minNumber(int[] nums1, int[] nums2) {
        int ans = nums1[0] * 10 + nums2[0];
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    ans = Math.min(num1, ans);
                    continue;
                }

                int temp1 = num1 * 10 + num2;
                int temp2 = num2 * 10 + num1;
                ans = Math.min(temp1, ans);
                ans = Math.min(temp2, ans);
            }
        }

        return ans;
    }

}
