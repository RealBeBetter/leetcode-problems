package leetcode75.trace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * @author wei.song
 * @since 2023/6/29 11:06
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        List<List<Integer>> lists = test.combinationSum3(3, 9);
        List<List<Integer>> lists1 = test.combinationSum3(4, 1);
        System.out.println(lists);
        System.out.println(lists1);
    }

    /**
     * 组合sum3
     *
     * @param count 数量
     * @param sum   总和
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> combinationSum3(int count, int sum) {
        return combinationSum3(count, count, sum, new ArrayList<>());
    }


    public List<List<Integer>> combinationSum3(int count, int maxCount, int sum, List<List<Integer>> result) {
        int max = 9;

        if (count == 0 || sum == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            for (List<Integer> temp : result) {
                int tempSum = temp.stream().reduce(Integer::sum).orElse(0);
                if (tempSum == sum && temp.size() == maxCount) {
                    ans.add(temp);
                }
            }
            return ans;
        }

        if (result.isEmpty()) {
            result = new ArrayList<>();
            for (int i = 1; i <= max; i++) {
                if (i <= sum) {
                    result.add(Collections.singletonList(i));
                }
            }
            return combinationSum3(count - 1, maxCount, sum, result);
        }

        List<List<Integer>> nextResult = new ArrayList<>();

        // result 不为空
        for (List<Integer> temp : result) {
            int tempSum = temp.stream().reduce(Integer::sum).orElse(0);
            Integer last = temp.get(temp.size() - 1);
            for (int i = last + 1; i <= max; i++) {
                if (tempSum + i <= sum) {
                    List<Integer> tempNext = new ArrayList<>(temp);
                    tempNext.add(i);
                    nextResult.add(tempNext);
                }
            }
        }

        return combinationSum3(count - 1, maxCount, sum, nextResult);
    }

}
