package problems.leet1_500;

/**
 * @author : Real
 * @date : 2021/12/3 23:52
 * @description : 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个
 * 下标 k（0 <= k < nums.length）上进行了旋转，使数组变为
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后
 * 可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，
 * 如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInRotatedSortedArray_33 {
    /**
     * 二叉搜索的变种，首先找到旋转点，之后判断往哪边走
     *
     * @param nums   数组，升序数组
     * @param target 目标值
     * @return 下标
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        // 升序数组，那么将会出现在靠近小值的一侧
        int left = 0;
        int right = nums.length - 1;
        int rotateIndex = 0;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (nums[0] <= nums[pivot]) {
                if (nums[0] <= target && target < nums[pivot]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            } else {
                if (nums[pivot] < target && target <= nums[nums.length-1]) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left <= right) {
            while (left <= right) {
                int pivot = left + (right - left) / 2;
                if (nums[pivot] > target) {
                    right = pivot - 1;
                } else if (nums[pivot] < target) {
                    left = pivot + 1;
                } else {
                    return pivot;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] array = {4, 5, 6, 7, 0, 1, 2};
        int[] array = {1};
        int target = 0;
        System.out.println(search(array, target));
    }
}
