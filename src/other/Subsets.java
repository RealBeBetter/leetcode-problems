package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wei.song
 * @since 2023/9/12 0:04
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets test = new Subsets();
        int[] array = {1, 2, 3};
        System.out.println(test.subsets(array));
        System.out.println(test.subsetsWithDfs(array));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.emptyList());

        for (int num : nums) {
            List<List<Integer>> newLists = new ArrayList<>();
            for (List<Integer> list : lists) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                newLists.add(newList);
            }
            lists.addAll(newLists);
        }

        return lists;
    }


    // --------------- DFS ------------------

    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDfs(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }


    /**
     * <a href="https://blog.csdn.net/xueyushenzhou/article/details/122473770">回溯算法</a>
     *
     * @param index 索引下标
     */
    private void dfs(int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不选 nums[i]
        dfs(index + 1);
        // 选 nums[i]
        path.add(nums[index]);
        dfs(index + 1);
        // 恢复现场，上一份结果添加之后，回退（成员变量，为了不影响下一次遍历的结果）
        path.remove(path.size() - 1);
    }


}
