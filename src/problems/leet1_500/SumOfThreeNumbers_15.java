package problems.leet1_500;

import java.util.*;

/**
 * @ author : Real
 * @ date : 2021/11/3 20:12
 * @ description : 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfThreeNumbers_15 {
    // 找出三数之和
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        // 答案一共有三种情况，正正负、负负正、正零负
        Arrays.sort(nums);
        // 按理说应该从负数或者0开始，否则将为null
        if (nums.length == 0 || nums[0] > 0 || nums.length < 3) {
            return ans;
        }
        // 另外的一种极端情况，之后的所有情况中都会存在负数
        if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(0);
            temp.add(0);
            ans.add(temp);
            return ans;
        }
        // 记录完毕 0 的 值之后就要判断是否开始对 存在 0 的情况进行统计
        for (int i = 0; i < nums.length; i++) {
            // 遍历方式，固定第一个，之后再固定第二个，移动第三个
            // 负负正，正正负，都从两边取值， 正 0 负 从中间开始取值
            // 直接使用左右指针的方式
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = nums[left] + nums[right];
                if (temp + nums[i] > 0) {
                    right--;
                } else if (temp + nums[i] < 0) {
                    left++;
                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    set.add(tempList);
                    left++;
                    right--;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }


    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(num));
    }
}
