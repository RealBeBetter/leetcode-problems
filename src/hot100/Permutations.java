package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Real
 * @since 2023/2/26 14:59
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        permutations(result, new ArrayList<>(), 0, nums, nums.length);
        return result;
    }

    private void permutations(List<List<Integer>> result, List<Integer> path, int index, int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        if (k == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        int length = nums.length;
        for (int i = index; i < length; i++) {
            path.add(nums[i]);
            permutations(result, path, index + 1, nums, k);
            result.remove(result.size() - 1);
        }

    }

}
