package leetcode75.interval;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 6927. 合法分割的最小下标
 * <a href="https://leetcode.cn/problems/minimum-index-of-a-valid-split">...</a>
 *
 * @author wei.song
 * @since 2023/7/16 11:17
 */
public class ValidSplit {

    public static void main(String[] args) {
        ValidSplit test = new ValidSplit();
        int[] array = {1, 1};
        int[] array1 = {1, 2, 2, 2};
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> list1 = Arrays.stream(array1).boxed().collect(Collectors.toList());
        System.out.println(test.minimumIndex(list));
        System.out.println(test.minimumIndex(list1));
    }

    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int mode = 0, total = 0;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > total) {
                total = countMap.get(num);
                mode = num;
            }
        }

        int freq1 = 0;
        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            freq1 += x == mode ? 1 : 0;
            if (freq1 * 2 > i + 1 && (total - freq1) * 2 > nums.size() - i - 1) {
                return i;
            }
        }
        return -1;
    }

}
