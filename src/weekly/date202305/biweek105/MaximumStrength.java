package weekly.date202305.biweek105;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 6393. 一个小组的最大实力值
 *
 * @author Real
 * @since 2023/5/27 22:42
 */
public class MaximumStrength {

    public static void main(String[] args) {
        MaximumStrength test = new MaximumStrength();
        int[] array = {0, -1};
        System.out.println(test.maxStrength(array));
    }

    public long maxStrength(int[] nums) {
        Arrays.sort(nums);

        // 从小到大排序
        List<Integer> negative = Arrays.stream(nums).filter(n -> n < 0).boxed().collect(Collectors.toList());
        List<Integer> zero = Arrays.stream(nums).filter(n -> n == 0).boxed().collect(Collectors.toList());
        List<Integer> positive = Arrays.stream(nums).filter(n -> n > 0).boxed().collect(Collectors.toList());
        if (negative.size() == 1 && positive.size() == 0) {
            if (zero.size() > 0) {
                return 0;
            } else {
                return nums[0];
            }
        }

        long ans = 0;
        int negativeSize = negative.size();
        if (negativeSize % 2 == 0 && negativeSize >= 2) {
            long tempSum = (long) negative.get(0) * negative.get(1);
            for (int i = 2; i < negativeSize; i++) {
                tempSum *= negative.get(i);
            }
            ans += tempSum;
        }
        if (negativeSize % 2 == 1 && negativeSize > 2) {
            long tempSum = (long) negative.get(0) * negative.get(1);
            for (int i = 2; i < negativeSize - 1; i++) {
                tempSum *= negative.get(i);
            }
            ans += tempSum;
        }

        if (positive.size() > 0) {
            long tempSum = 1;
            for (Integer temp : positive) {
                tempSum *= temp;
            }
            ans = ans == 0 ? tempSum : ans * tempSum;
        }

        return ans;
    }

}
