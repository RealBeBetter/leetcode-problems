package weekly.date2023.date202304.week341;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 6350. 找出可整除性得分最大的整数
 *
 * @author Real
 * @since 2023/4/16 10:46
 */
public class FindMaximumDivisibilityScore {

    public int maxDivScore(int[] nums, int[] divisors) {
        TreeMap<Integer, Integer> scoreDivisorMap = new TreeMap<>(Comparator.reverseOrder());

        divisors = Arrays.stream(divisors).distinct().sorted().toArray();

        for (int divisor : divisors) {
            int score = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }

            if (!scoreDivisorMap.containsKey(score)) {
                scoreDivisorMap.put(score, divisor);
            }
        }

        Map.Entry<Integer, Integer> firstEntry = scoreDivisorMap.firstEntry();
        return firstEntry.getValue();
    }

}
