package weekly.date202305.week347;

/**
 * 6455. 使所有字符相等的最小成本
 *
 * @author Real
 * @since 2023/5/28 11:28
 */
public class MinimumCostEqual {

    public static void main(String[] args) {
        MinimumCostEqual test = new MinimumCostEqual();
        System.out.println(test.minimumCost("010101"));
        System.out.println(test.minimumCost("0"));
        System.out.println(test.minimumCost("00010000"));
    }

    public long minimumCost(String s) {
        long min = 0;
        for (int i = 1; i < s.length(); i++) {
            min += s.charAt(i - 1) == s.charAt(i) ? 0 : Math.min(i, s.length() - i);
        }
        return min;
    }
}
