package plan.binary;

/**
 * @author Real
 * @since 2023/3/1 22:30
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {-1, 0, 3, 5, 9, 12};
        System.err.println(search(array, 9));
    }


    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
