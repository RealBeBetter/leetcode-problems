package problems.leet1_500;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * @author : Real
 * @date : 2021/12/3 23:28
 */
public class FindFirstAndLastPositionOfElement {

    public static int[] searchRange(int[] nums, int target) {
        // 不存在或数组为空
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 使用二分查找
        int left = 0;
        int right = nums.length - 1;
        int tempIndex = -1;
        int[] ans = new int[2];
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else if (target > nums[pivot]) {
                left = pivot + 1;
            } else {
                tempIndex = pivot;
                break;
            }
        }

        // 找到连续的或者是未找到
        if (tempIndex == -1) {
            // 未找到
            return new int[]{-1, -1};
        } else {
            // 找到目标值
            while (tempIndex >= 0 && nums[tempIndex] == target) {
                tempIndex--;
            }
            ans[0] = tempIndex + 1;
            // 需要移动至结束位置
            tempIndex++;
            while (tempIndex <= nums.length - 1 && nums[tempIndex] == target) {
                tempIndex++;
            }
            ans[1] = tempIndex - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(array, target)));
    }

}
