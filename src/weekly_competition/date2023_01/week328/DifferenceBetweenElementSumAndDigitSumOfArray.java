package weekly_competition.date2023_01.week328;

/**
 * 6291. 数组元素和与数字和的绝对差
 * 给你一个正整数数组 nums 。
 * 元素和 是 nums 中的所有元素相加求和。
 * 数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
 * 返回 元素和 与 数字和 的绝对差。
 * 注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,15,6,3]
 * 输出：9
 * 解释：
 * nums 的元素和是 1 + 15 + 6 + 3 = 25 。
 * nums 的数字和是 1 + 1 + 5 + 6 + 3 = 16 。
 * 元素和与数字和的绝对差是 |25 - 16| = 9 。
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 解释：
 * nums 的元素和是 1 + 2 + 3 + 4 = 10 。
 * nums 的数字和是 1 + 2 + 3 + 4 = 10 。
 * 元素和与数字和的绝对差是 |10 - 10| = 0 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 2000
 * 1 <= nums[i] <= 2000
 *
 * @author wei.song
 * @since 2023/1/15 22:02
 */
public class DifferenceBetweenElementSumAndDigitSumOfArray {

    public static void main(String[] args) {
        DifferenceBetweenElementSumAndDigitSumOfArray test = new DifferenceBetweenElementSumAndDigitSumOfArray();
        int[] array = {1, 15, 6, 3};
        System.out.println(test.differenceOfSum(array));
    }

    public int differenceOfSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int num : nums) {
            boolean oneDigit = Math.abs(num) < 10;
            if (oneDigit) {
                continue;
            }
            int self = num;
            int digitSum = 0;
            while (num >= 10) {
                digitSum += num % 10;
                num /= 10;
            }
            digitSum += num;
            ans += Math.abs(self - digitSum);
        }
        return ans;
    }

}
