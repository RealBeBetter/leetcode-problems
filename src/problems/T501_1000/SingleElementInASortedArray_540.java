package problems.T501_1000;

/**
 * @ author : Real
 * @ date : 2021/11/2 17:08
 * @ description : 540. 有序数组中的单一元素
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 示例 1:
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * 提示:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i]<= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleElementInASortedArray_540 {
    public int singleNonDuplicate(int[] nums) {
        // 直接判断
        int flag = 0;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (i+1 != nums.length) {
                    if (nums[i] != nums[i+1]) {
                        return nums[i];
                    }
                } else {
                    return nums[i];
                }
            }
        }
        return 0;

        // 使用HashMap记录数量，复杂度O(2n)
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                return integer;
            }
        }
        return 0;*/
    }
}
