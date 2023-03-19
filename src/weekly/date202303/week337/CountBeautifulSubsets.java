package weekly.date202303.week337;

/**
 * 6352. 美丽子集的数目
 *
 * @author Real
 * @since 2023/3/19 11:30
 */
public class CountBeautifulSubsets {
    private static boolean beautiful = true;

    public static void main(String[] args) {
        CountBeautifulSubsets test = new CountBeautifulSubsets();
        test.checkSubsetsBeautiful(0, new int[]{2, 4, 6}, 2);
        System.out.println(beautiful);
    }

    /**
     * 美丽子集个数，k>=1，默认单个数字均符合
     *
     * @param nums 原数组
     * @param k    k
     * @return int
     */
    public int beautifulSubsets(int[] nums, int k) {


        return 0;
    }

    private void checkSubsetsBeautiful(int start, int[] nums, int k) {
        if (start < 0 || start >= nums.length || !beautiful) {
            return;
        }

        int length = nums.length;
        int currentNumber = nums[start];
        for (int i = start + 1; i < length; i++) {
            if (Math.abs(currentNumber - nums[i]) == k) {
                beautiful = false;
                return;
            }
        }

        start++;
        checkSubsetsBeautiful(start, nums, k);
    }

}
