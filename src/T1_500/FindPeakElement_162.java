package T1_500;

/**
 * @author : Real
 * @date : 2021/12/4 9:57
 * @description : 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPeakElement_162 {

    /**
     * 对于当前可行的下标范围 [l,r]，我们随机一个下标 i；
     * 如果下标 i 是峰值，我们返回 i 作为答案；
     * 如果 nums[i]<nums[i+1]，那么我们抛弃 [l,i] 的范围，
     * 在剩余 [i+1,r] 的范围内继续随机选取下标；
     * 如果 nums[i]>nums[i+1]，那么我们抛弃 [i,r] 的范围，
     * 在剩余 [l,i−1] 的范围内继续随机选取下标。
     *
     * @param nums 数组
     * @return 下标值
     */
    public static int findPeakElement(int[] nums) {
        // 寻找峰值元素的索引值，大于两侧数字
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 1};
        int[] array2 = {1, 2, 1, 3, 5, 6, 4};

        System.out.println(findPeakElement(array2));
    }
}
