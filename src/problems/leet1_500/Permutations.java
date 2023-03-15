package problems.leet1_500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Real
 * @since 2023/3/15 18:45
 */
public class Permutations {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(permute(array));
    }

    /**
     * 全排列
     *
     * @param nums 数组
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> currentPermute = new ArrayList<>();
        for (int num : nums) {
            List<Integer> permuteNumbers = new ArrayList<>();
            permuteNumbers.add(num);
            currentPermute.add(permuteNumbers);
        }

        return recursionPermute(nums, currentPermute);
    }

    private static List<List<Integer>> recursionPermute(int[] nums, List<List<Integer>> currentPermutes) {
        if (currentPermutes.get(0).size() == nums.length) {
            return currentPermutes;
        }

        List<List<Integer>> nextPermutes = new ArrayList<>();
        for (List<Integer> currentPermute : currentPermutes) {
            for (int num : nums) {
                if (!currentPermute.contains(num)) {
                    List<Integer> nextPermute = new ArrayList<>(currentPermute);
                    nextPermute.add(num);
                    nextPermutes.add(nextPermute);
                }
            }
        }

        return recursionPermute(nums, nextPermutes);
    }

}
