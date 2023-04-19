package problems.leet1_500;

/**
 * 219. 存在重复元素II
 *
 * @author wei.song
 * @since 2023/04/19 11:17
 */
public class ContainsDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
